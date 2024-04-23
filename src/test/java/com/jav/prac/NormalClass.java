package com.jav.prac;

public class NormalClass extends AbstractClassExm implements TestInter{
	

	public static void main(String[] args) {
		NormalClass nn = new NormalClass();
		nn.test1();
		nn.method21();
		
		nn.test(4);
	}

	@Override
	public void test1() {
		System.out.println("This is abstract method");
	}

	@Override
	public void method21() {
		System.out.println("This is interface method");
		
	}

	@Override
	public void method33() {
		// TODO Auto-generated method stub
		
	}


}
