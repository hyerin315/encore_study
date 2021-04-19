package com.encore.inter;
class ImplInterA implements InterA{

	@Override
	public void printNum() {
		System.out.println(NUM);
	}
}

public class InterAMain {

	public static void main(String[] args) {
		ImplInterA ia = new ImplInterA();
		ia.printNum();
	}
}
