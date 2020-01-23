package net.syscon.s4.eoffender.watcher.config;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import net.syscon.s4.eoffender.watcher.Utils.CommonUtils;
import net.syscon.s4.eoffender.watcher.auth.EoffenderOAuth;

@Component
public class WatcherService {
  
	@Autowired
	private WatchService watchService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	volatile ScheduledFuture<?> t;
	ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(6);
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	
	private Map<String, Long> filesUploadedTimeMap = new HashMap<>();
	private Map<String, Long> filesOpenTimeMap = new HashMap<>();
	private Map<String, Boolean> newFileUploadMap = new HashMap<>();
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	private CommonUtils commonUtils;
	
	public void startWatchService() {
		WatchKey key;
		
		try {
			while ((key = watchService.take()) != null) {
				for (WatchEvent<?> event : key.pollEvents()) {
					
					if("ENTRY_CREATE".equals(event.kind().name())){
						
						// CHECK FILE IS VALID DOCX
						if(event.context().toString().contains("~$") || event.context().toString().contains("Unconfirmed")){
							continue;
						}
						
						if(!event.context().toString().endsWith(".docx") ){
							continue;
						}
						
						try {
						Desktop.getDesktop();	
						if (Desktop.isDesktopSupported()) {

								if(filesOpenTimeMap.containsKey(event.context().toString())){
									continue;
								}
								
//								if(!event.context().toString().startsWith("EDITED")) {
//									File folder = new File("C:\\Users\\amol.singh\\Desktop\\eoffender_docs");
//									Optional<File> latestFile = Arrays.stream(folder.listFiles()).filter(f -> f.getName().equals(event.context().toString())).sorted((f1, f2) -> (int)f2.lastModified() - (int)f1.lastModified()).findFirst();
//									String generatedFileKey = CommonUtils.getKeyFromDocxFile(latestFile.get().getAbsolutePath());
//							        FileInputStream insertFile = new FileInputStream(latestFile.get());
//							        byte[] byteArray = IOUtils.toByteArray(insertFile);
//							        insertFileByteArray(byteArray, generatedFileKey);
//							        insertFile.close();
//								}
								
								filesOpenTimeMap.put(event.context().toString(), System.currentTimeMillis());
								System.out.println("Opening file :: "+event.context());
								Desktop.getDesktop().open(new File(env.getProperty("watcher.downloadPath") + event.context()));	

							}
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
						
					}
					
					
					if("ENTRY_MODIFY".equals(event.kind().name())){
						
						// CHECK FILE IS VALID DOCX
						if(event.context().toString().contains("~$") || event.context().toString().contains("Unconfirmed")){
							continue;
						}
						
						if(!event.context().toString().endsWith(".docx") ){
							continue;
						}
						
						// FOR EDIT FUNCTIONALITY
						if(event.context().toString().startsWith("EDITED")) {
							t = null;
							t = scheduledThreadPoolExecutor.scheduleAtFixedRate(getUploadRunnable(event.context().toString(), env.getProperty("watcher.downloadPath")), 2, 12, TimeUnit.SECONDS);
						} else {
							// IT IS NEW FILE
							// SAVE LATEST FILE IN DB
							
							File folder = new File(env.getProperty("watcher.downloadPath.temp"));
							Optional<File> latestFile = Arrays.stream(folder.listFiles()).filter(f -> f.getName().equals(event.context().toString())).sorted((f1, f2) -> (int)f2.lastModified() - (int)f1.lastModified()).findFirst();
					        if(!latestFile.isPresent()){
					        	System.out.println("File is Not Present !!!!!!!!!");
					        	return;
					        }
							
					        String generatedFileKey = commonUtils.getKeyFromDocxFile(event.context().toString());
					        FileInputStream insertFile = new FileInputStream(latestFile.get());
					        byte[] byteArray = IOUtils.toByteArray(insertFile);
					        insertFileByteArray(byteArray, generatedFileKey);
					        insertFile.close();
						}
						
					}
					
					System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
				}
				key.reset();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private Runnable getUploadRunnable(String fileName, String path) {
		Runnable uploadRunnable = () -> {

			System.out.println("Checking file is Open or not");
			try {
				if (!isWordFileOpen(fileName)) {
         
					filesOpenTimeMap.clear();
//					if (filesUploadedTimeMap.containsKey(fileName)) {
//						System.out.println("ERROR -- File just uploaded :: " + fileName);
//					} else {

					File folder = new File(env.getProperty("watcher.downloadPath.temp"));
					Optional<File> latestFile = Arrays.stream(folder.listFiles())
							.filter(f -> f.getName().equals(fileName))
							.sorted((f1, f2) -> (int) f2.lastModified() - (int) f1.lastModified()).findFirst();
					if (!latestFile.isPresent()) {
						System.out.println("File is Not Present !!!!!!!!!");
						return;
					}

					byte[] byteArray = IOUtils.toByteArray(new FileInputStream(latestFile.get()));

					String editFileDBKey = generateRandomString();
					insertFileByteArray(byteArray, editFileDBKey);

					Map<String, String> uploadResult = uploadDocmentFromSchedular(editFileDBKey,
							latestFile.get().getName());
					if ("SUCCESS".equals(uploadResult.get(fileName))) {
						System.out.println(uploadResult);
						t.cancel(false);
						Files.deleteIfExists(latestFile.get().toPath());
					}
					
				}
			} catch (Exception e) {
				t.cancel(true);
				e.printStackTrace();
			}
		};
        
		return uploadRunnable;
	}
	
	private String generateRandomString() {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 7;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    System.out.println(generatedString);
	    
	    return generatedString;
	}
	
	
	public void insertFileByteArray(byte[] fileByteArray, String key) throws Exception {   
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement("INSERT INTO EOFFENDER_DOCUMENTS_2 (ID_GENERATED, FILE_DATA) VALUES (?, ?)");
	          ps.setString(1, key);
	          ps.setBlob(2, new ByteArrayInputStream(fileByteArray), fileByteArray.length);
	          return ps;
	        });
	 }
	
	
    private static Map<String, String> uploadDocmentFromSchedular(String key, String fileName) throws Exception {
		
    	String authToken = EoffenderOAuth.getAuthToken();
    	
    	HttpClient httpClient = HttpClientBuilder.create().build();
    	URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost:8080")
				.setPath("/Elite2Web/api/eoffender/document/uploadFromSchedular").setParameter("key", key);
    	
    	URI uri = builder.build();
    	HttpPost httpPost = new HttpPost(uri);
    	httpPost.addHeader("Authorization", "Bearer" + authToken); 
        HttpResponse response = httpClient.execute(httpPost);
        int responseCode = response.getStatusLine().getStatusCode();  
    	
		return null;
	}
	
	
	private boolean isWordFileOpen(String fileName){
		boolean isWordFileOpen = false;
	    try {
	    	File destDir = new File(env.getProperty("watcher.downloadPath.temp"));
	        File srcFile = new File(env.getProperty("watcher.downloadPath") + File.separator + fileName );
	        FileUtils.moveFileToDirectory(srcFile, destDir, true);
	    } catch(Exception e) {
	    	isWordFileOpen = true;
	    	System.out.println(e.getLocalizedMessage() + " :: " + fileName);	    	
	    }
	    
	    return isWordFileOpen;
	}
	
}
