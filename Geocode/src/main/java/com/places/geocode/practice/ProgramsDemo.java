package com.places.geocode.practice;

import java.util.HashSet;
import java.util.Set;

public class ProgramsDemo {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 5, 2, 8, 1, 12 };
		// maxLengthSubArrayOfSum9(a, 8);
		rotateArrayToRight(a, 3);
	}

	static void maxLengthSubArrayOfSum9(int[] a, int maxSum) {
		Set<Integer> subArrayLengthSet = new HashSet<>();
		int sum = 0;
		for (int i = 0, k = 0; i < a.length; i++) {
			sum += a[i];

			if (sum == maxSum) {
				subArrayLengthSet.add(k);
				k = 0;
				continue;
			}

			k++;
		}

		int maxSubArrayLength = subArrayLengthSet.stream().max((i, j) -> i - j).get();
		System.out.println(maxSubArrayLength);
	}

	// [1, 3, 5, 2, 8, 1, 12]
	static void rotateArrayToRight(int[] a, int k) {
		int temp = a[0];
		int t;
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < a.length; i++) {
				if (i + 1 == a.length) {
					a[0] = temp;
					continue;
				}
				t = a[i + 1];
				a[i + 1] = temp;
				temp = t;
			}
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
