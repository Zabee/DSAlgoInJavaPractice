package com.zabee.dsalgo.myexperiments;

import java.util.Arrays;

public class MyStringBuilder {

	private char[] value;
	private int capacity;
	private int counter;

	public MyStringBuilder() {
		capacity = 16;
		value = new char[capacity];
	}

	public MyStringBuilder(int argCapacity) {
		this.capacity = argCapacity;
		value = new char[capacity];
	}

	public MyStringBuilder(String argStr) {
		this.capacity = argStr.length() + 16;
		value = new char[capacity];
	}

	public void append(String str) {
		ensureCapacity(str.length());
		System.arraycopy(str.toCharArray(), 0, value, counter, str.length());
	}

	public void append(char[] str) {
		ensureCapacity(str.length);
		System.arraycopy(str, 0, value, counter, str.length);
	}

	public void append(boolean str) {
		ensureCapacity(10);
		if (str) {
			value[counter++] = 't';
			value[counter++] = 'r';
			value[counter++] = 'u';
			value[counter++] = 'e';
		} else {
			value[counter++] = 'f';
			value[counter++] = 'a';
			value[counter++] = 'l';
			value[counter++] = 's';
			value[counter++] = 'e';
		}
	}

	public void append(int str) {
		String strOfInt = String.valueOf(str);
		ensureCapacity(strOfInt.length());
		System.arraycopy(strOfInt.toCharArray(), 0, value, counter, strOfInt.length());
	}

	public void append(long str) {
		String strOfLong = String.valueOf(str);
		ensureCapacity(strOfLong.length());
		System.arraycopy(strOfLong.toCharArray(), 0, value, counter, strOfLong.length());
	}

	public void append(float str) {
		String strOfFloat = String.valueOf(str);
		ensureCapacity(strOfFloat.length());
		System.arraycopy(strOfFloat.toCharArray(), 0, value, counter, strOfFloat.length());
	}

	public void append(double str) {
		String strOfDouble = String.valueOf(str);
		ensureCapacity(strOfDouble.length());
		System.arraycopy(strOfDouble.toCharArray(), 0, value, counter, strOfDouble.length());
	}

	private void ensureCapacity(int size) {
		// TODO handle overflows
		// Let's keep a counter here
		counter = counter + size;

		if (counter + size > capacity) {
			capacity = capacity << 1; // Doubling capacity every time
			value = Arrays.copyOf(value, capacity); // Adjust (increases in this case) size of array "value" and copies
													// all characters to it pads remaining with null
		}
	}
	
	@Override
	public String toString() {
		return new String(value);
	}
}
