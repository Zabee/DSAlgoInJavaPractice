package com.zabee.allaboutmemory;

import java.math.BigInteger;
import java.security.CryptoPrimitive;
import java.util.*;
import java.util.logging.Logger;

import org.apache.logging.log4j.LoggingException;

import junit.framework.Test;

public class ClassLoadersDemo {

	public static void main(String[] args) {
		System.out.println("Bootstrap class loader starts***********************************");
		System.out.println("Boolean class loader?	" + Boolean.class.getClassLoader());
		System.out.println("Byte class loader?		" + Byte.class.getClassLoader());
		System.out.println("Short class loader?		" + Short.class.getClassLoader());
		System.out.println("Integer class loader?	" + Integer.class.getClassLoader());
		System.out.println("Long class loader?		" + Long.class.getClassLoader());
		System.out.println("Float class loader?		" + Float.class.getClassLoader());
		System.out.println("Double class loader?	" + Double.class.getClassLoader());
		System.out.println("Double class loader?	" + Double.class.getClassLoader());
		System.out.println("List class loader?		" + List.class.getClassLoader());
		System.out.println("ArrayList class loader?	" + ArrayList.class.getClassLoader());
		System.out.println("Bootstrap loader ends***********************************\n");

		System.out.println("Extenstion class loader starts**************************");
		System.out.println("A class from $JAVA_HOME/lib/ext ?	" );	
		System.out.println("Extenstion class loader ends**************************\n");

		System.out.println("Application class loader starts**************************");
		System.out.println("Logging class loader?	" + ClassLoadersDemo.class.getClassLoader());
		System.out.println("Application class loader ends**************************\n");

	}

}
