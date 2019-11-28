package com.watcherservice.LinuxWatcherService;

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
import jcifs.smb.SmbFileOutputStream;

public class DirectoryWatcherExample {
	 
    public static void main(String[] args) throws IOException, InterruptedException {
    	
//        String user = "amol.singh@espire.com";
//        String pass ="vision@12";
//
//        String sharedFolder="shared";
//        String path="smb://172.16.5.78/"+sharedFolder+"/test.txt";
//        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("",user, pass);
//        SmbFile smbFile = new SmbFile(path,auth);
//        SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFile);
//        smbfos.write("testing....and writing to a file".getBytes());
//        System.out.println("completed ...nice !");
    	
    	
        WatchService watchService = FileSystems.getDefault().newWatchService();
 
        //Path path = Paths.get("\\\\172.16.2.36\\acu");
        Path path = Paths.get("smb://172.16.5.78//root//watcherService//watcherServiceDirectory");
 
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