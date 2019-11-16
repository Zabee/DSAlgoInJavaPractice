package com.zabee.allaboutmemory;

public class FinalInJava {

	public static void main(String[] args) {
		final Employee emp;
		emp = new FinalInJava().new Employee();
		processMe(emp);
		System.out.println(emp.eName);
	}

	private static void processMe(final Employee emp) {
//		emp = new FinalInJava().new Employee();
		emp.eName = "Zabee";
	}

	private class Employee {
		private String eName;
		private int age;
	}
}
