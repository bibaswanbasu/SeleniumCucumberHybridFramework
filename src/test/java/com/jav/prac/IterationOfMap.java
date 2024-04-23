package com.jav.prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IterationOfMap {

	public static void main(String[] args) {

		iterateOverKeyByWhile();
		iterateOverKeyByFor();
		iterateOverValueByWhile();
		iterateOverEntrySetUsingWhile();
		iterateOverEntrySetUsingFor();	//mostly used

	}

	public static Map<String, Integer> arrayToMapConverstion() {

		// [[ Storing String map to a HashMap ]]
		String shoppingApp[] = { "amazon", "flipkart", "myntra", "mesho", "zepto", "spencer", "amazon", "flipkart",
				"flipkart" };

		Map<String, Integer> map = new HashMap<>();

		for (String app : shoppingApp) {
			if (map.containsKey(app)) {
				map.put(app, map.get(app) + 1);
			} else {
				map.put(app, 1);
			}
		}

		return map;
	}

	public static void iterateOverKeyByWhile() {
		System.out.println(">>>> Iterate Map using Key and While Loop <<<<");

		Map<String, Integer> arrayMap = arrayToMapConverstion();

		Iterator<String> arrayKey = arrayMap.keySet().iterator();

		while (arrayKey.hasNext()) {
			String key = arrayKey.next();
			int value = arrayMap.get(key);
			System.out.println(key + "  >> " + value);
			if(value>1) {
				System.out.println("[[ Duplicate ]] " + key + " With Count > " + value);
			}
		}
	}

	public static void iterateOverKeyByFor() {
		System.out.println(">>>> Iterate Map using Key and For Loop <<<<");

		Map<String, Integer> arrayMap = arrayToMapConverstion();

		for (String key : arrayMap.keySet()) {
			int value = arrayMap.get(key);
			System.out.println(key + " >> " + value);
			if(value>1) {
				System.out.println("[[ Duplicate ]] " + key + " With Count > " + value);
			}
		}
	}

	public static void iterateOverValueByWhile() {
		System.out.println(">>>> Iterate Map using Value and While Loop <<<<");

		Map<String, Integer> arrayMap = arrayToMapConverstion();

		Iterator<Integer> arrayValues = arrayMap.values().iterator();

		while (arrayValues.hasNext()) {

			System.out.println(arrayValues.next());
		}
	}

	public static void iterateOverEntrySetUsingWhile() {
		System.out.println(">>>> EntrySet ++ While Loop <<<<");

		Map<String, Integer> arrayMap = arrayToMapConverstion();

		Iterator<Entry<String, Integer>> arrayValues = arrayMap.entrySet().iterator();

		while (arrayValues.hasNext()) {
			Entry<String, Integer> itr = arrayValues.next();
			if (itr.getValue() > 1) {
				System.out.println("Duplicate " + itr.getKey() + " >> " + itr.getValue());
			}
		}
	}

	public static void iterateOverEntrySetUsingFor() {
		System.out.println(">>>> EntrySet ++ For Loop <<<<");

		Map<String, Integer> arrayMap = arrayToMapConverstion();

		for (Entry<String, Integer> arrayValues : arrayMap.entrySet()) {

			System.out.println(arrayValues.getKey() + " : " + arrayValues.getValue());
			if (arrayValues.getValue() > 1) {
				System.out
						.println("[[ Duplicate ]] " + arrayValues.getKey() + " With Count > " + arrayValues.getValue());
			}
		}

	}

}
