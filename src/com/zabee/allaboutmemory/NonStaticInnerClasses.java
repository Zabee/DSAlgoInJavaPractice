package com.zabee.allaboutmemory;

public class NonStaticInnerClasses {
	private static int someNumber = 10;

	public static void main(String[] args) {

	}
	
	private static class NonStaticInnerClass{
		private static int innerNumber = 20;
	}

}
