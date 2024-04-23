package com.jav.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertHashMaptoArrayList {

	public static void main(String[] args) {
//		convertHashmapToArraylist();
		convertion();
	}

	public static void convertHashmapToArraylist() {

		Map<String, Integer> chMap = new HashMap<>();

		chMap.put("Buglu", 33);
		chMap.put("Sounak", 32);
		chMap.put("Pratyush", 31);

		List<String> name = new ArrayList<>(chMap.keySet());
		for (String i : name) {
			System.out.println(i);
		}

		List<Integer> age = new ArrayList<>(chMap.values());
		for (Integer j : age) {
			System.out.println(j);
		}

	}

	public static void convertion() {
		String str[] = { "a", "b", "c" };

		List<String> lis1 = new ArrayList<>();
		System.out.println(lis1.size());

		List<String> lis2 = Arrays.asList(str);
		for (String s : lis2) {
			System.out.println(s);

		}
		
		for(String s : str) {
			lis1.add(s);
		}

		System.out.println(lis1.size());

	}

}
