package com.places.geocode.practice.multithreading;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;

public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
//    	Runtime r = Runtime.getRuntime();
//    	Process p  = r.exec("cmd /c start C:\\\\Users\\\\amol.singh\\\\Desktop\\\\eoffender_docs\\\\0000530748-BLD.docx"); 
    	
    	File destDir = new File("C:\\\\Users\\\\amol.singh\\\\Desktop");
        File srcFile = new File("C:\\\\Users\\\\amol.singh\\\\Desktop\\\\eoffender_docs\\\\0000530748-BLD,IEY-ICORSR-20-12-2019 (2) (12).docx");
        //FileUtils.copyFileToDirectory(srcFile, destDir);
        FileUtils.moveFileToDirectory(srcFile, destDir, true);
//    	File file = new File("C:\\Users\\amol.singh\\Desktop\\eoffender_docs\\0000530748-BLD.docx");
//    	
//    	boolean isFileUnlocked = false;
//    	try {
//    	    org.apache.commons.io.FileUtils.touch(file);
//    	    isFileUnlocked = true;
//    	} catch (IOException e) {
//    	    isFileUnlocked = false;
//    	}
//
//    	if(isFileUnlocked){
//    	    // Do stuff you need to do with a file that is NOT locked.
//    	} else {
//    	    // Do stuff you need to do with a file that IS locked
//    	}
    	
		//System.out.println(calculateAsync().get());
		
        //CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> "Amol").thenApplyAsync(s -> s.concat(" Singh"));
		//System.out.println(nameFuture.get());
    	ExecutorService executor = Executors.newFixedThreadPool(2);
    
		Runnable count1To11 = () -> {
			IntStream.range(1, 11).forEach(i -> System.out.println(i + " "));
		};
		
		Runnable count1To11Different = () -> {
			IntStream.range(1, 11).forEach(i -> System.out.println(i + " Different"));
		};
		
		Runnable sleepingTask = () -> {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		};
//		
//		CompletableFuture<Void> sleepingtask = CompletableFuture.runAsync(sleepingTask, executor).exceptionally(ex -> {
//			System.out.println(ex.getMessage());
//			return null;
//		});

		//CompletableFuture.runAsync(sleepingTask, executor).get();
		
		System.out.println("Amol Singh");
		
		CompletableFuture.runAsync(count1To11Different, executor);

//		CompletableFuture<Void> finalFuture = CompletableFuture.anyOf(countingTaskDiff, countingTask)
//				.thenRunAsync(() -> System.out.println("All Tasks completed"));
		
		//finalFuture.get();
		executor.shutdown();
	} 
   
}


interface Display{
	String displayName();
}

