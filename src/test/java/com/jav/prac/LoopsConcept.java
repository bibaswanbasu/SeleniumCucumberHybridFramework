package com.jav.prac;

import org.testng.annotations.Test;

public class LoopsConcept {

	@Test
	public static void loopsTest() {

//		int i = 0;
//		while (i <= 20) {
//			System.out.println(i);
//			i++;
//		}

		int j = 20;

		do {
			j++;
			System.out.println(j);
		} while (j <= 30);
	}

	@Test
	public static void pyramidTest() {

		int num = 10;
		int runTime = 4;

		for (int i = runTime; i <= 1; i--) {
			System.out.println(runTime);

		}

	}

	// Find Out the minimum number from the multi dimentional array and then the the max number from that column
	@Test
	public static void minNumFromMultiArray() {

		int num[][] = { { 3, 5, 5 }, { 8, 3, 7 }, { 5, 4, 9 }, { 5, 5, 2 } };
		int minNum = num[0][0];
		int minColumnNum = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (num[i][j] < minNum) {
					minNum = num[i][j];
					// Also identify the column number where the lowest number present
					minColumnNum = j;
				}
			}
		}

		int maxNum = num[0][minColumnNum];

		for (int r = 0; r < 4; r++) {
			if (num[r][minColumnNum] > maxNum) {
				maxNum = num[r][minColumnNum];
			}

		}

		System.out.println("Minimum Number is >> " + minNum);
		System.out.println("Minimum Number Present in Column : " + minColumnNum);
		System.out.println("Maximum number in the column is >> " + maxNum);

	}

}
