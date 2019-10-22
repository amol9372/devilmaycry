package com.practice.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RecursionDemo {
	
	public static void main(String[] args) {
        String x = "100010011";
        System.out.println(getBinaryFormat(1041));
        List<Integer> l = Arrays.asList(1,2,5,0,3,23);
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(1, 3); countMap.put(2, 1); countMap.put(3, 20); countMap.put(4, 12); countMap.put(5, 6);
        
        System.out.println(countMap.entrySet().stream().min((c1, c2) -> c1.getValue() - c2.getValue()).get().getKey());
        
        Optional<Integer> n = l.stream().max((n1, n2) -> n1 - n2);
        System.out.println(n.get());
        
        int[] a = {3, 1, 2, 4, 3};
        
        System.out.println(getMinimumDiff(a));
	}
	
	static int returnNumber(int x){
		if(x == 4){
			return x;
		}
		
		return returnNumber(x-1);
	}
	
	// [3, 2, 1, 4, 5]
	
	private static int getMinimumDiff(int[] a) {

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		int sumRight = 0;
		int sumLeft = 0;
		int diffMin = 0;

		for (int i = 0, c = 0; i < a.length; i++, c++) {
			sumLeft += a[i];
			sumRight = sum - sumLeft;
			int diffNew = Math.abs(sumRight - sumLeft);
			
			if(c == 0){
			   diffMin = diffNew;	
			}
			
			if(c > 0){
			   	if(diffNew < diffMin){
			   		diffMin = diffNew;
			   	}
			}
			
		}

		return diffMin;
	}
	
	static void inOrderExample(int x){
		if(x == 0)
			return;
		
		inOrderExample(x - 1);
		System.out.print(x + " ");
		
	}
	
	private static String getBinaryFormat(int n){
        if(n == 0 || n == 1)
          return String.valueOf(n);
          
        else {
            return  String.valueOf(getBinaryFormat(n/2)) + String.valueOf(n % 2);  
        }  
    }
	
	private static void printPermutations(String s){
		
	}
}


