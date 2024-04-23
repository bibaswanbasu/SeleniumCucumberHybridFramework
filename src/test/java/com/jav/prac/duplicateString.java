package com.jav.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class duplicateString {

	public static void main(String[] args) {
		duplicateString.duplicateFinderWithSet("Bibaswan");
		duplicateString.duplicateFinderWithComparison("Bibaswan");
		duplicateString.duplicateWordFinder("My Name IS Bib is Bib mY MY");
		removeDuplicate();
	}

	public static void duplicateFinderWithSet(String text) {
		System.out.println(">>>> Found Duplicate Character using Set interface <<<<");

		Set<Character> duplicateChar = new HashSet();

		for (char ch : text.toLowerCase().toCharArray()) {

			/**
			 * This is a approach: if the Character is not getting add in Set its a
			 * duplicate
			 */
			if (!duplicateChar.add(ch)) {
				System.out.println("Duplicate- " + ch);
			}

			/**
			 * This is another approach: if the HashSet does not contains that Character its a duplicate 
			 * else it will add the character to the HashSet
			 */
//			if (duplicateChar.contains(ch)) {
//
//				System.out.println("Duplicate- " + ch);
//
//			} else {
//
//				duplicateChar.add(ch);
//			}
		}

	}

	public static void duplicateFinderWithComparison(String text) {
		System.out.println(">>>> Found Duplicate Character By Comparing each charecter <<<<");

		char[] ch = text.toLowerCase().toCharArray();

		for (int i = 0; i < text.length(); i++) {
//			char newChar = text.charAt(i);

			for (int j = i + 1; j < text.length(); j++) {
				if (ch[i] == ch[j]) {
					System.out.println("Duplicate Character : " + ch[i]);
					break;

				}
			}
		}

	}

	public static void duplicateWordFinder(String sentence) {
		System.out.println("Duplicate Word Finder >>>>>");
		String[] word = sentence.toLowerCase().split(" ");

		for (int i = 0; i < word.length; i++) {
//			System.out.println(word[i]);
			for (int j = i + 1; j < word.length; j++) {
				if (word[i] == word[j]) {
					System.out.println("Duplicate Word is - " + word[i]);
				}
			}
		}

	}
	
	public static void removeDuplicate() {
		int[] arrayAll = { 2, 4, 3, 2, 3, 3, 4, 5, 6, 5, 2 };

		for (int a : arrayAll) {
			System.out.print(a + ", ");
		}
		System.out.println();
		System.out.println("---- Using Set ----");

		// 1. Using Set interface we can directly remove duplicate
		Set<Integer> duplicateSet = new HashSet<Integer>();

		for (int a : arrayAll) {
			duplicateSet.add(a);
		}

		System.out.println(duplicateSet);

		System.out.println("---- Using Linked HashSet ----");

		// 2. Using LinkedHashSet we can directly remove duplicate
		LinkedHashSet<Integer> newLinkedhashSet = new LinkedHashSet<Integer>();
		for (int i : arrayAll) {
			newLinkedhashSet.add(i);
		}

		System.out.println(newLinkedhashSet);
		
		System.out.println("---- Using Normal for loop ----");
		//3. Normal for loop
		int rd= 0;
		ArrayList<Integer> newArray = new ArrayList<Integer>();
//		 2, 4, 3, 2, 3, 3, 4, 5, 6, 5, 2 
		
		for(int i=0; i<arrayAll.length; i++) {
			if(arrayAll[rd] != arrayAll[i]) {
				arrayAll[++rd] = arrayAll[i];
				
			}
		}
		
	}

}
