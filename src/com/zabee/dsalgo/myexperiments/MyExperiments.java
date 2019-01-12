package com.zabee.dsalgo.myexperiments;

import java.util.HashMap;
import java.util.Map;

public class MyExperiments {

	public static void main(String[] args) {
//		printPowerOfSome(2, 11);

//		String [] words = {"This", "That", "What", "When", "Here"};
//		String sentence = joinWords(words);
//		System.out.println(sentence);
//		
//		char [][] charWords = {{'T','h','i','s'},{'T','h','i','s'},{'T','h','i','s'},{'T','h','i','s'}};
//		sentence = joinWords(charWords);
//		System.out.println(sentence);
		// Well, now I started learn Python so getting a bit specific here, although
		// this is a Java IDE
//		hashAndEqualsContractInJava();

		// Page 636 i.e. enter 647 in pdf. Okay, find a substring s in give string B
		// It has been said that run time is O(s(b-s)) for a bruteforce algorithm. Let's
		// try
		String b = "doe are hearing me", s = "re";
		subStringSinStringBBruteForce(b, s);
	}

	/**
	 * O((n-m)*m)
	 * 
	 * @param b
	 * @param s
	 */
	private static void subStringSinStringBBruteForce(String b, String s) {
		char[] bChars = b.toCharArray(), sChars = s.toCharArray();
		int i = 0, j = 0;
		for (; i < bChars.length && j < sChars.length; i++) {
			if (bChars[i] != sChars[j]) {
				j = 0;
			} else {
				j++;
			}

		}
		if (j == sChars.length) {
			System.out.println("Found substring at starting index: " + (i - sChars.length));
		} else {
			System.out.println("Not a substring");
		}

	}

	private static void hashAndEqualsContractInJava() {
		Map<Employee, Department> empDeptMap = new HashMap<Employee, Department>();
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setEmpName("Zabee");

		Department dept1 = new Department();
		dept1.setDeptId(1);
		dept1.setDeptName("CS");

		Department dept2 = new Department();
		dept2.setDeptId(2);
		dept2.setDeptName("IS");

		empDeptMap.put(emp1, dept1);
		empDeptMap.put(emp1, dept2);

		Department dept = empDeptMap.get(emp1);
		System.out.println(dept.getDeptId());

	}

	/**
	 * O(n)
	 * 
	 * @param base
	 * @param power
	 */
	private static void printPowerOfSome(int base, int power) {
		long result = 1;
		for (int i = 1; i <= power; i++) {
			result = result * base;
		}
		System.out.println("Power of base " + base + " power " + power + " is : " + result);
	}

	/**
	 * O(n)
	 * 
	 * @param argWords
	 * @return
	 */
	private static String joinWords(String[] argWords) {
		String sentence = "";
		for (String word : argWords) {
			sentence = sentence + word;
		}
		return sentence;
	}

	private static String joinWords(char[][] argWords) {
		char[] sentence = new char[1024];
		for (int i = 0, k = 0; i < argWords.length; i++) {
			char[] word = argWords[i];
			for (int j = 0; j < word.length; j++, k++) {
				sentence[k] = word[j];
			}
		}
		return String.valueOf(sentence);
	}
}

class Employee {
	private int empId;
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Employee emp = (Employee) obj;
		if (emp.empId == this.empId)
			return true;
		else
			return false;
	}
}

class Department {
	private int deptId;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	private String deptName;
}