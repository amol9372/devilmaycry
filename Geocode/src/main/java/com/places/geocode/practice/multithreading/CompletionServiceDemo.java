package com.places.geocode.practice.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
		//System.out.println(calculateAsync().get());
		
        //CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> "Amol").thenApplyAsync(s -> s.concat(" Singh"));
		//System.out.println(nameFuture.get());
		
		Runnable count1To11 = () ->  {  IntStream.range(1, 11).forEach(i -> System.out.println(Thread.currentThread().getName() + " " + i + " "));  } ;
		
		Runnable count11To21 = () ->  {  IntStream.range(11, 21).forEach(i -> System.out.println(Thread.currentThread().getName() + " " + i + " "));  } ;
		
		Runnable sleepingTask = () -> {
			try {
				System.out.println("Sleeping Thread is sleeping");
				Thread.sleep(4000);
				System.out.println("Sleeping Thread is done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		CompletableFuture<Void> countFuture = CompletableFuture.runAsync(count1To11);
		
		//Thread.sleep(5000);
		//System.out.println("Main thread is running .... ");
		//countFuture.complete(null);
		
		
	} 
    
    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
     
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });
        return completableFuture;
    }
   
}


interface Display{
	String displayName();
}

