package com.zabee.just.java.practice;

/**
 * Everything is call by value but with Objects and arrays (int []) a copy of
 * reference (an extra pointer will be created to the memory location and that
 * pointer) will be passed. So any changes to the members (object members and
 * array members) will reflect but when you reassign the passed object/array to
 * something those will no longer pointing to the original one and hence no
 * change to it.
 */

public class CallByVaueAndByReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		testArrayCallByValueOrReference(intArray);
		System.out.println("Array's values after method call : ");
		for (int x : intArray) {
			System.out.print(x + ",");
		}
		System.exit(-1);
		char argChar = 'c';
		byte argByte = -1;
		short argShort = -2;
		int argInteger = 1234;
		// Please note that by default the precision will be double not float, so have
		// to append 'f' to it as below
		float argFlot = 23.2334f;
		double argDouble = 34345.3453453;
//Same with Long please add 'L'		
		long argLong = 345646436l;
		System.out.println("Printing before sending to the checkAndChangeMe() method");
		System.out.println(argChar);
		System.out.println(argByte);
		System.out.println(argShort);
		System.out.println(argInteger);
		System.out.println(argFlot);
		System.out.println(argDouble);
		System.out.println(argLong);
		checkAndChangeMe(argChar, argByte, argShort, argInteger, argFlot, argDouble, argLong);

		System.out.println("Printing after return from checkAndChangeMe() method for PRIMITIVES");
		System.out.println(argChar);
		System.out.println(argByte);
		System.out.println(argShort);
		System.out.println(argInteger);
		System.out.println(argFlot);
		System.out.println(argDouble);
		System.out.println(argLong);

		// Every initialization is getting auto boxed from literal to Wrapper classes'
		// object
		Character characterObject = 'c';
		Byte byteObject = 1;
		Short shortObject = 2;
		Integer integerObject = 1234;
		Float flotObject = 23.2334F;
		Double doubleObject = 34345.3453453;
		Long longObject = 3456464L;
		String strObject = "Zabee";
		MyString myString = new MyString(1234);
		System.out.println("Printing before sending to the checkAndChangeMe() method");

		System.out.println(characterObject);
		System.out.println(byteObject);
		System.out.println(shortObject);
		System.out.println(integerObject);
		System.out.println(flotObject);
		System.out.println(doubleObject);
		System.out.println(longObject);
		System.out.println(strObject);
		System.out.println(myString);

		checkAndChangeMe(characterObject, byteObject, shortObject, integerObject, flotObject, doubleObject, longObject,
				strObject, myString);

		System.out.println("Printing after return from checkAndChangeMe() method WRAPPER CLASSES' OBJECTS");
		System.out.println(characterObject);
		System.out.println(byteObject);
		System.out.println(shortObject);
		System.out.println(integerObject);
		System.out.println(flotObject);
		System.out.println(doubleObject);
		System.out.println(longObject);
		System.out.println(strObject);
		System.out.println(myString);

	}

	/**
	 * Primitive data types. Should be call by value.
	 * 
	 * @param argChar
	 * @param argByte
	 * @param argShort
	 * @param argInteger
	 * @param argFlot
	 * @param argDouble
	 * @param argLong
	 */
	private static void checkAndChangeMe(char argChar, byte argByte, short argShort, int argInteger, float argFlot,
			double argDouble, long argLong) {
		System.out.println("Changing their values PRIMITIVES");
		argChar = 'd';
		argByte = 2;
		argShort = 3;
		argInteger = 5678;
		argFlot = 100.2334f;
		argDouble = 10000.3453453;
		argLong = 100000L;
	}

	/**
	 * Wrapper classes should be call by reference
	 * 
	 * @param characterObject
	 * @param byteObject
	 * @param shortObject
	 * @param integerObject
	 * @param flotObject
	 * @param doubleObject
	 * @param longObject
	 */
	private static void checkAndChangeMe(Character characterObject, Byte byteObject, Short shortObject,
			Integer integerObject, Float flotObject, Double doubleObject, Long longObject, String strObject,
			MyString myString) {
		System.out.println("Changing their values WRAPPER CLASSES OBJECTS");
		characterObject = 'd';
		byteObject = 2;
		shortObject = 3;
		integerObject = 5678;
		flotObject = 100.2334f;
		doubleObject = 10000.3453453;
		longObject = 100000L;
		strObject = "Shubham";
		myString.objectInteger = (4567);
	}

	private static void testArrayCallByValueOrReference(int[] intArary) {
		intArary = new int[5];
		for (int i = 0; i < 5; i++) {
			intArary[i] = 0;
		}
		System.out.println("Array's values inside method : ");
		for (int x : intArary) {
			System.out.print(x + ",");
		}
	}

}

class MyString {
	int objectInteger;

	public MyString(int argInt) {
		objectInteger = argInt;
	}

	@Override
	public String toString() {
		return Integer.toString(objectInteger);
	}
}