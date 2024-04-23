package com.jav.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Pracjav {

	public static void main(String[] args) {

		System.out.println(zeroToLast("1200304005"));
//		System.out.println(zeroToFirst("1200304005"));
//		System.out.println(zeroToFirstStrngBldr("1200304005"));

//		stringB();

	}

	public static String zeroToLast(String number) {
		// 1. Convert the String to char type Array
		char[] charArray = number.toCharArray();

		int nonZeroCount = 0;

		// 2. Iterate the array using for loop
		for (int i = 0; i < charArray.length; i++) {
			// 3. Using if statement will check the non 0 element
			if (charArray[i] != '0') {
				// 4. Will store the non zero number to 	a char variable
				char temp = charArray[i];
				// 5. Value of index i overwritten the value of charecter
				charArray[i] = charArray[nonZeroCount];
				charArray[nonZeroCount] = temp;
				// 6. Increase the nonZeroCount count by 1
				nonZeroCount++;
			}
		}

		return new String(charArray);

	}

	public static String zeroToFirst(String number) {
		// 1. Convert the String to char type Array
		char[] charArray = number.toCharArray();

		int nonZeroCount = charArray.length - 1;

		// 2. Iterate the array using for loop starting from the last
		for (int i = charArray.length - 1; i >= 0; i--) {
			// 3. Using if statement will check the non 0 element
			if (charArray[i] != '0') {
				// 4. Will store the zero to a char variable
				char temp = charArray[i];
				// 5. Value of index i overwritten the value of charecter
				charArray[i] = charArray[nonZeroCount];
				charArray[nonZeroCount] = temp;
				// 6. decrease the nonZeroCount count by 1
				nonZeroCount--;
			}
		}

		return new String(charArray);

	}

	public static String zeroToFirstStrngBldr(String number) {
		StringBuilder result = new StringBuilder();
		StringBuilder zeros = new StringBuilder();

		for (char c : number.toCharArray()) {
			if (c == '0') {
				zeros.append(c);
			} else {
				result.append(c);
			}
		}

		result.append(zeros.toString());

		return result.toString();

	}

	public static void stringB() {
//		StringBuilder sb = new StringBuilder(strng);

		String s = "Biba";
		s = "Biba2";
//		String s2 = new String("ABC");
//		s = s+s1;

		System.out.println(s);

	}

}
