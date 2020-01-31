package com.practice.corejava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletionServiceDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        
		// Submit Task 1
		CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
		    try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		    }
		    System.out.println("Task 1 completed");
		    return 5;
		});
		// Submit Task 2
		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
		    try {
		        Thread.sleep(3000);
		    } catch (InterruptedException e) {
		    }
		    System.out.println("Task 2 completed");
		    return 7;
		});
		// This call will create a future that will wait for f1 and f2 to complete
		// and then execute the runnable
		/*
		 * CompletableFuture.allOf(f1, f2).thenRun(() -> {
		 * System.out.println("Both completed"); });
		 */
		//f1.get();
		f1.thenAcceptBothAsync(f2, (a, b) -> System.out.println("Result = " + (a + b)));
		System.out.println("main thread exiting .... ");
	}
}
