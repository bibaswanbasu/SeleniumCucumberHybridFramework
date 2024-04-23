package com.jav.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JavaPract {

	public static void main(String[] args) {
//		duplicateFinder("Bibaswanann");
//		zeroToLast(120300405607L);
		pyramid();
	}

	public static void duplicateFinder(String inputText) {
		Map<Character, Integer> charCount = new HashMap<>();
		char[] inputChar = inputText.toLowerCase().toCharArray();

		for (int i = 0; i < inputChar.length; i++) {

			if (charCount.containsKey(inputChar[i])) {
				charCount.put(inputChar[i], charCount.get(inputChar[i]) + 1);
			} else {
				// If the character is not present, add it to the map with count 1
				charCount.put(inputChar[i], 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {

			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " >> " + entry.getValue());

			}
		}
		
		System.out.println("-----------------------");

		Iterator<Map.Entry<Character, Integer>> itr = charCount.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<Character, Integer> dup = itr.next();
			System.out.println(dup.getKey() + " -- " + dup.getValue());

		}

	}

	public static void zeroToLast(long number) {
		char[] numArray = Long.toString(number).toCharArray();
		String nonZero = "";
		String zeroNum = "";

		for (char num : numArray) {
			if (num != '0') {
				nonZero += num;
			} else {
				zeroNum += num;
			}
		}

		System.out.println(Long.parseLong(nonZero + zeroNum));

	}

	public static void pyramid() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows for the pyramid: ");
		int numRows = scanner.nextInt();

		for (int i = 1; i <= numRows; i++) {
			// Print spaces before the asterisks
			for (int j = 1; j <= numRows - i; j++) {
				System.out.print(" ");
			}

			// Print asterisks for the current row
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}

			// Move to the next line after each row
			System.out.println();
		}

		scanner.close();
	}

}
