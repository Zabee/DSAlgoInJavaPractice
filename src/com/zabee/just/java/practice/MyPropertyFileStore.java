package com.zabee.just.java.practice;

import java.io.IOException;
import java.util.Properties;

public class MyPropertyFileStore {

	public static void main(String a[]) throws IOException {

		Properties prop = new Properties();
		prop.setProperty("name", "java2novice");
		prop.setProperty("domain", "www.java2novice.com");
		prop.setProperty("email", "java2novice@gmail.com");
		
	}
}