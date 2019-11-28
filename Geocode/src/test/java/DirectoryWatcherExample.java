import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

public class DirectoryWatcherExample {
	 
    public static void main(String[] args) throws IOException, InterruptedException {
        
//      String user = "amol.singh@espire.com";
//      String pass ="vision@12";
//
//		
//		String windowsPath = "smb:////172.16.4.137//";
//		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("espire.com", user, pass);
//		SmbFile smbFile = new SmbFile(windowsPath, auth);
////		SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFile);
////		smbfos.write("testing....and writing to a file".getBytes());
////		System.out.println("completed ...nice !");
      
    	WatchService watchService = FileSystems.getDefault().newWatchService();
// 
       Path path = Paths.get(System.getProperty("user.dir"));
        //Path path = Paths.get(smbFile);
        
        
        System.out.println(path.toString());
        path.register(
          watchService, 
            StandardWatchEventKinds.ENTRY_CREATE, 
              StandardWatchEventKinds.ENTRY_DELETE, 
                StandardWatchEventKinds.ENTRY_MODIFY);
 
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                  "Event kind:" + event.kind() 
                    + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }
    }
}