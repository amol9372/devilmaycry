package com.practice.corejava;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class LambdaExceptions {
     
	 public static void main(String[] args) {
		 
		 
	     IntStream.range(1, 11).forEach((IntConsumer) ThrowingConsumer.unchecked(i -> System.out.println(i)));    	
	 }
	 
	 static void printNumbers(int i) throws Exception {
		 if( i > 10 ) {
			 throw new Exception();
		 }
	 }
	 
	 
}


@FunctionalInterface
interface ThrowingConsumer<T, E extends Throwable> {
	void accept(T t) throws E;

	static <T, E extends Throwable> Consumer<T> unchecked(ThrowingConsumer<T, E> consumer) {
		return (t) -> {
			try {
				consumer.accept(t);
			} catch (Throwable e) {
				System.out.println(e.getLocalizedMessage());
			}
		};
	}
}