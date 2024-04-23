package com.jav.prac;

public class PalyndromCheck {
	public static void main(String[] args) {
		checkPalyndrom("TST");
		checkPalyndromInt(120021);
	}

	public static void checkPalyndrom(String word) {

		char[] strArray = word.toCharArray();

		String reverse = "";

		for (int i = strArray.length - 1; i >= 0; i--) {
			reverse += strArray[i];
		}

		if (reverse.equals(word)) {
			System.out.println("Its a Palindrom Number: " + word);
		} else {
			System.out.println("Its not a Palindrom");
		}

	}
	
	public static void checkPalyndromInt(int num) {
		String word = Integer.toString(num);
		char[] strArray = word.toCharArray();

		String reverse = "";

		for (int i = strArray.length - 1; i >= 0; i--) {
			reverse += strArray[i];
		}

		if (reverse.equals(word)) {
			System.out.println("Its a Palindrom Number: " + word);
		} else {
			System.out.println("Its not a Palindrom");
		}

	}

}
