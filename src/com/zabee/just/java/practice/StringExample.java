package com.zabee.just.java.practice;

import java.util.StringJoiner;

public class StringExample {

	public static void main(String[] args) {
		String str = new String("This is String object");
		str = str.concat("!");
		System.out.println(str);
		StringJoiner strJoiner = new StringJoiner(",", "[", "]");
		strJoiner.add("!");
		strJoiner.add("!");
		strJoiner.add("!");
		strJoiner.add("!");
		strJoiner.add("!");
		System.out.println(strJoiner);
		
		String s = "0123456789012345678901234567890123456789";
		String s2 = s.substring(0, 1);
		s = null;
		System.out.println(s);
		System.out.println(s2);
	}

}
