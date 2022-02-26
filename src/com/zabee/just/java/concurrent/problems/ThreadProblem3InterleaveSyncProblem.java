package com.zabee.just.java.concurrent;

public class ThreadProblem3InterleaveSyncProblem {

	public static void main(String[] args) {
		ColorRGB color = new ColorRGB(0, 0, 0, "Pitch Black");
		ColorThread1 t1 = new ColorThread1(color);
		ColorThread2 t2 = new ColorThread2(color);
		t1.start();
		t2.start();

	}

}

class ColorThread1 extends Thread {
	private ColorRGB color;

	public ColorThread1(ColorRGB color) {
		this.color = color;
	}

	@Override
	public void run() {
		synchronized (color) {
			color.set(0, 0, 255, "Blue");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
			System.out.println(color.getColorName());
		}
	}
}

class ColorThread2 extends Thread {
	private ColorRGB color;

	public ColorThread2(ColorRGB color) {
		this.color = color;
	}

	@Override
	public void run() {
		synchronized (color) {
			color.set(255, 255, 255, "Pure white");
			System.out.println(color.getColorName());
		}
	}
}

class ColorRGB {
	private int red;
	private int green;
	private int blue;
	private String colorName;

	private void check(final int... colorValues) {
		for (int colorValue : colorValues) {
			if (colorValue < 0 || colorValue > 255) {
				throw new IllegalArgumentException();
			}
		}
	}

	public ColorRGB(final int argRed, final int argGreen, final int argBlue, String argColorName) {
		check(argRed, argGreen, argBlue);
		this.red = argRed;
		this.green = argGreen;
		this.blue = argBlue;
		this.colorName = argColorName;
	}

	public synchronized String getColorName() {
		return colorName;
	}

	public synchronized void set(final int argRed, final int argGreen, final int argBlue, String argColorName) {
		check(argRed, argGreen, argBlue);
		this.red = argRed;
		this.green = argGreen;
		this.blue = argBlue;
		this.colorName = argColorName;
	}
}


class Parent{
	public Parent() {
		
	}
}

class Child extends Parent{
	
}
