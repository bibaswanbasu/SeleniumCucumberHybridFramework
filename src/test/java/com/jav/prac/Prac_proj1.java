package com.jav.prac;

public class Prac_proj1 {

	public static String reverseString(String input) {
		String reversedString = "";

		for (int i = input.length() - 1; i >= 0; i--) {

			reversedString += input.charAt(i);

		}

		// Return the reversed string
		return reversedString;

	}

	public static void main(String[] args) {
		// Test your reverseString method with different inputs
		String input1 = "Hello, World!";
		String input2 = "Java Programming";
		String input3 = "12345";

		System.out.println("Original String 1: " + input1);
		System.out.println("Reversed String 1: " + reverseString(input1));
		System.out.println();

		System.out.println("Original String 2: " + input2);
		System.out.println("Reversed String 2: " + reverseString(input2));
		System.out.println();

		System.out.println("Original String 3: " + input3);
		System.out.println("Reversed String 3: " + reverseString(input3));
	}
}
