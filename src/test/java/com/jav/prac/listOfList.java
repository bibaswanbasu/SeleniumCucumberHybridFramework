package com.jav.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listOfList {

	public static void listHandle() {

		List<List<String>> mainList = new ArrayList<>();

		List<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");

		List<String> list2 = new ArrayList<>();
		list2.add("X");
		list2.add("Y");
		list2.add("Z");
		list2.add("test");

		List<String> list3 = new ArrayList<>();
		list3.add("1");
		list3.add("2");
		list3.add("3");

		mainList.add(list1);
		mainList.add(list2);
		mainList.add(list3);

		mainList.get(1).add("test");

		for (List<String> innerList : mainList) {
			System.out.println(innerList);
		}

	}

	public static void arrayToArrayKist() {
		String[] arr = { "Buglu", "Chintu", "Sounak" };
		System.out.println(arr[1]);

		// Using asList method converting the array to list
		List<String> arrLst = Arrays.asList(arr);
		System.out.println("Size of List - " + arrLst.size());

		// But can not add any further data to the list, it will through
		// 'UnsupportedOperationException'
//		arrLst.add(null);

		// Can create a new arraylist and using for loop can add old string array and
		// then can add new
		List<String> newArrLst = new ArrayList<>();

		for (String lst : arrLst) {
			newArrLst.add(lst);
		}

		newArrLst.add("NewBuglu");

		System.out.println("New ArrayList Size - " + newArrLst.size());

	}

	public static void main(String[] args) {
		listHandle();
//		arrayToArrayKist();
	}

}
