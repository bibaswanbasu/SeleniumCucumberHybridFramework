package com.java.collection.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class prac1 {

	public static void main(String[] args) {
		String str[] = { "amazon", "flipkart", "myntra", "mesho", "zepto", "spencer", "amazon", "flipkart",
				"flipkart" };

		System.out.println("------- USING BRUTE FORCE -------");
		for (int i = 0; i <= str.length - 1; i++) {
			for (int j = i + 1; j <= str.length - 1; j++) {
				if (str[i] == str[j]) {
					System.out.println(str[i]);
				}
			}
		}

		System.out.println("------- USING SET -------");

		Set<String> newSet = new HashSet<String>();
		for (String n : str) {
			if (!newSet.add(n)) {
				System.out.println("Duplicate String - " + n);
			}

		}

		System.out.println("------- USING HASHMAP -------");
		Map<String, Integer> map = new HashMap<>();

		for (String n : str) {

			Integer count = map.get(n);
			if (count == null) {
				map.put(n, 1);
			} else {
				map.put(n, count + 1);
			}

		}

		System.out.println(map);

		Iterator<Integer> it = map.values().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Iterator<String> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		Iterator<Map.Entry<String, Integer>> itr3 = map.entrySet().iterator();
		

		while (itr3.hasNext()) {
			Map.Entry<String, Integer> mapItr = itr3.next();

			System.out.println(mapItr.getKey() + " : " + mapItr.getValue());
		}

	}

}
