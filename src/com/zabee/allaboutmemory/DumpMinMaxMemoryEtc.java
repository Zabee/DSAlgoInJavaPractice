package com.zabee.allaboutmemory;

public class DumpMinMaxMemoryEtc {

	public static void main(String[] args) {
		System.out.println("Free memory: " + (Runtime.getRuntime().freeMemory()/1024)/1024 + " MB");
		System.out.println("Free memory: " + (Runtime.getRuntime().maxMemory()/1024)/1024 + " MB");
		System.out.println("Free memory: " + (Runtime.getRuntime().totalMemory()/1024)/1024 + " MB");
	}

}
