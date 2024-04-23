package com.jav.prac;

public class FizzBuzz {

	public static int findMissingNumber(int[] arr) {
		int n = arr.length;
		int expectedSum = n * (n + 1) / 2; // Sum of numbers from 0 to n
		int actualSum = 0;

		for (int num : arr) {
			actualSum += num;
		}

		return expectedSum - actualSum;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 3, 4, 5 }; // Missing number is 2
		int missingNumber = findMissingNumber(arr);
		System.out.println("Missing number: " + missingNumber);
	}
}
