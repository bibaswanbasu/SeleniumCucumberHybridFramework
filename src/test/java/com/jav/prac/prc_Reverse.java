package com.jav.prac;

public class prc_Reverse {

	public static void main(String[] args) {

//		normalReverseString("EMAN YM SI ULGUB");
		reverseStringCharSeq("BUGLU IS NAME MY");
		reverseStringChar("olleH dlroW eyB eyB");
//		reverseMiddleChar("Hlleo Wlrod Blguu");

	}

	public static void normalReverseString(String input) {

		String reversedString = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			reversedString = reversedString + input.charAt(i);

		}
		System.out.println(input + " >> " + reversedString);

	}

	public static void reverseStringCharSeq(String input) {

		String[] splitString = input.split(" ");

		String reversedString = "";

		for (int i = splitString.length - 1; i >= 0; i--) {
//			reversedString += splitString[i] + " ";
			reversedString = reversedString + splitString[i] + " ";

		}
		System.out.println(input + " >> " + reversedString);

	}

	public static void reverseStringChar(String input) {

		String[] splitString = input.split(" ");

		String reversedString = "";

		for (int i = 0; i < splitString.length; i++) {
			if (i > 0) {
				reversedString += " ";
//				reversedString = reversedString + " ";
			}
			for (int j = splitString[i].length() - 1; j >= 0; j--) {
				reversedString += splitString[i].charAt(j);
			}
		}
		System.out.println(input + " >> " + reversedString);
	}

	public static void reverseMiddleChar(String inputString) {
		String[] words = inputString.split(" ");
		String outputString = "";

		for (int i = 0; i < words.length; i++) {
			char fristChar = words[i].charAt(0);
			char lastChar = words[i].charAt(words[i].length() - 1);
			String reversedMiddle = "";

			if (i > 0) {
				outputString += " ";
			}

			for (int j = words[i].length() - 2; j >= 1; j--) {
				reversedMiddle = reversedMiddle + words[i].charAt(j);

			}
			outputString += fristChar + reversedMiddle + lastChar;
		}

		System.out.println("Original string: " + inputString);
		System.out.println("Modified string: " + outputString);

	}

}
