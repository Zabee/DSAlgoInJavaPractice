package com.zabee.just.java.practice;

public final class ImmutableClass {

	final int x, y;

	ImmutableClass(final int x, final int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
