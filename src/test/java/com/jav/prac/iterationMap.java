package com.jav.prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class iterationMap {

	public static void main(String[] args) {
		iterationMap.iterateMap("Bibaswan");

	}

	public static void iterateMap(String text) {

		char[] ch = text.toCharArray();
		Map<String, Integer> chMap = new HashMap<>();

		chMap.put("Buglu", 33);
		chMap.put("Sounak", 32);
		chMap.put("Pratyush", 31);

//		 1. One common way is Using entrySet() method along with For Each loop
		System.out.println(">>> Using entrySet() method with For Each loop <<<");
		for (Map.Entry<String, Integer> entry : chMap.entrySet()) {

			System.out.println("Age Of " + entry.getKey() + " is " + entry.getValue());

		}

		// 2. We Can also Use iterator() method with while loop
		System.out.println(">>> Using iterator() method with while loop <<<");
		Iterator<Map.Entry<String, Integer>> itr = chMap.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Integer> entry = itr.next();

			System.out.println("Age Of " + entry.getKey() + " is " + entry.getValue());

		}

		// 3. In java 8 we can use forEach(action) method with lambda expression, this
		// is clean and fast
		System.out.println(">>> Using forEach(action) method with lambda expression <<<");
		chMap.forEach((k, v) -> System.out.println("Age Of " + k + " is " + v));

		// 4. Iterating over keys and search for the values
		System.out.println(">>> Iterating over keys and search for the values <<<");
		for (String name : chMap.keySet()) {
			int age = chMap.get(name);
			System.out.println("Age Of " + name + " is " + age);
		}

		// 5. Iterating over keys or values using keySet() and values() methods

	}

}
