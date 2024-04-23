package com.jav.prac;

import java.util.Arrays;

public class Prac_AnagramCheck {

	public static boolean areAnagrams(String str1, String str2) {
		boolean areAnagrams = false;
		char[] str1CHar = str1.toCharArray();
		char[] str2Char = str2.toCharArray();
		
		Arrays.sort(str1CHar);
		Arrays.sort(str2Char);
		
		String value1 = String.valueOf(str1CHar);
		String value2 = String.valueOf(str2Char);
		
		areAnagrams = value1.equals(value2);

		return areAnagrams;
	}

	public static void main(String[] args) {
		// Test your areAnagrams method with different inputs
		String input1 = "listen";
		String input2 = "silent";
		System.out.println("Are \"" + input1 + "\" and \"" + input2 + "\" anagrams? " + areAnagrams(input1, input2));

		String input3 = "java";
		String input4 = "python";
		System.out.println("Are \"" + input3 + "\" and \"" + input4 + "\" anagrams? " + areAnagrams(input3, input4));
	}
}
