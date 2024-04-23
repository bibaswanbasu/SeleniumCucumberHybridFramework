package com.jav.prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class duplicateFinderWithCount {

	public static void duplicateWithCount(String text) {

		char[] cArr = text.toLowerCase().toCharArray();

		Map<Character, Integer> dupMap = new HashMap<>();

		for (char c : cArr) {
			if (dupMap.containsKey(c)) {
				dupMap.put(c, dupMap.get(c) + 1);
			} else {
				dupMap.put(c, 1);
			}
		}
		
		System.out.println("Iteratre Using iterator() method =>");

		Iterator<Map.Entry<Character, Integer>> it = dupMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Character, Integer> entry = it.next();
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " : " + entry.getValue() + " times");
			}

		}

		System.out.println("Iteratre Using For Loop With the Help of entrySet() =>");

		for (Map.Entry<Character, Integer> entry : dupMap.entrySet()) {

			if (entry.getValue() > 1) {

				System.out.println(entry.getKey() + " : " + entry.getValue() + " times");
			}

		}

	}

	public static void main(String[] args) {
		duplicateWithCount("Hello, World!");
	}

}
