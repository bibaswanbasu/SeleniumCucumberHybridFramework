package com.jav.prac;

public abstract class AbstractClassExm{
	
	public AbstractClassExm() {
		System.out.println("This is constructor");
	}
	
	public AbstractClassExm(String test) {
		System.out.println("This is Parametarise constructor");
	}

	public void test() {
		
		System.out.println("Test");
	}
	
	public void test(String str) {
		System.out.println("Test");
	}
	
	public void test(int text) {
		System.out.println("Test");
	}

	public abstract void test1();

}
