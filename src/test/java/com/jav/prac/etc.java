package com.jav.prac;

import java.util.Arrays;

public class etc extends Exception {

	public static void arrayTask() {
		String[] names = { "Charlie", "Alice", "David", "Bob" };
		Arrays.sort(names);

		for (String s : names) {
			System.out.print(s + " ");

		}
	}

	public static void expStringBuilder() {
		// StringBuilder is a mutable class

		String str = "Welcome";
		StringBuilder sb = new StringBuilder(str);
		// apend() function
		sb.append(" World");
		// insert [it insert a charecter or string after provided charecter count]
		sb.insert(13, " Future");
		// delete() [provide start and end index
		sb.delete(8, 14);
		sb.reverse();
		System.out.println(sb);
	}

	public static void main(String[] args) {
//		arrayTask();
		expStringBuilder();

	}

}
