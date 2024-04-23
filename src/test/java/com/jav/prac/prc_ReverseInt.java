package com.jav.prac;

public class prc_ReverseInt {

	public static void reverseNum(int number) {
		
		

		int reversedNum = 0;
        while (number != 0) {		
            int remainder = number % 10;
            reversedNum = reversedNum * 10 + remainder;
            number /= 10;
        }
         System.out.println(reversedNum);
	}

	

	public static void main(String[] args) {

//		reverseNum(987654321);
//		reverseStringCharSeq("BUGLU IS NAME MY");
//		reverseStringChar("Hello World Bye Bye");
//		reverseMiddleChar("Hlleo Wlrod");
//		rve();
		


	}
	
	

}
