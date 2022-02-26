package com.zabee.just.java.concurrent;

public class ImmutableColorRBGB {
	final private int red;
	final private int green;
	final private int blue;
	final private String colorName;

	private void check(final int... colorValues) {
		for (int colorValue : colorValues) {
			if (colorValue < 0 || colorValue > 255) {
				throw new IllegalArgumentException();
			}
		}
	}

	public ImmutableColorRBGB(final int argRed, final int argGreen, final int argBlue, String argColorName) {
		check(argRed, argGreen, argBlue);
		this.red = argRed;
		this.green = argGreen;
		this.blue = argBlue;
		this.colorName = argColorName;
	}

	public synchronized String getColorName() {
		return colorName;
	}

	public synchronized ImmutableColorRBGB set(final int argRed, final int argGreen, final int argBlue, String argColorName) {
		check(argRed, argGreen, argBlue);
		return new ImmutableColorRBGB(argRed, argGreen, argBlue, argColorName);
	}
}
