package com.places.geocode.practice.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
		//System.out.println(calculateAsync().get());
		
        //CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> "Amol").thenApplyAsync(s -> s.concat(" Singh"));
		//System.out.println(nameFuture.get());
    	Executor executor = Executors.newFixedThreadPool(2);
		Runnable count1To11 = () ->  {  IntStream.range(1, 11).forEach(i -> System.out.println(Thread.currentThread().getName() + " " + i + " "));  } ;
		
		Runnable count11To21 = () ->  {  IntStream.range(11, 21).forEach(i -> System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isDaemon() + " " + i + " "));  } ;
		
		Runnable sleepingTask = () -> {
			try {
				System.out.println("Sleeping Thread is sleeping");
				Thread.sleep(4000);
				System.out.println("Sleeping Thread is done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		//CompletableFuture<Void> countFuture = CompletableFuture.runAsync(sleepingTask, executor);
		
		CompletableFuture.supplyAsync(() -> {
		    return "Some result";
		}).thenApplyAsync(result -> {
		    // Executed in a thread obtained from the executor
		    return "Processed Result";
		}, executor);
		
		
	} 
   
}


interface Display{
	String displayName();
}

