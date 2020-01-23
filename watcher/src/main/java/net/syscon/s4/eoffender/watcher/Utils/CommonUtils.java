package net.syscon.s4.eoffender.watcher.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
     
	@Autowired
	private Environment env;
	

	public Optional<File> getLatestFileFromFileSystem(){
		
		File folder = new File(env.getProperty("watcher.downloadPath"));
		Optional<File> latestFile = Arrays.stream(folder.listFiles()).sorted((f1, f2) -> (int)f2.lastModified() - (int)f1.lastModified()).findFirst();
        
		return latestFile;
	}
	
	public String getKeyFromDocxFile(String fileName) throws InvalidFormatException, IOException {
		String key = null;
		try(OPCPackage opc = OPCPackage.open(env.getProperty("watcher.downloadPath") + File.separator + fileName);) {
            
			PackageProperties pp = opc.getPackageProperties();
			Optional<String> templateNameUriOptional = pp.getCategoryProperty();
			if (templateNameUriOptional.isPresent()) {
				String[] templateNameUri = templateNameUriOptional.get().split("-");
				key = templateNameUri[4];
			}
		}catch(EmptyFileException ex){
			System.out.println("getPropertiesFromDocxFile :: The supplied file was empty (zero bytes long)"+ex.getMessage());
		}
		return key;
	}
	
	public static boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0)
			return true;
		return false;
	}
}
