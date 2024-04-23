package com.jav.prac;

public class StarPattern_proj {

	public static void main(String[] args) {
		firstStartPattern();
	}

	public static void firstStartPattern() {
		int z = 5;

		String star = "*";

		for (int i = 1; i <= z; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
