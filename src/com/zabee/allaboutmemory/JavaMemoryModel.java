package com.zabee.allaboutmemory;

/**
 * {@code 
 * JVM memory area is divided into two main parts.
 * (1) Thread stacks: Every primitive variable lives here that belongs to a thread. The objects used by the threads are referenced from here but are 
 * 						stored in heap space, of course. The variables of one thread is not at all visible to other threads. 
 * (2) Heap			: Every object and every member of the object lives here. The static members lives with the class definition.
 * }
 *
 */
public class JavaMemoryModel {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();

	}

	private static class MyThread extends Thread {
		@Override
		public void run() {
			methodOne();
		}

		private void methodOne() {
			int localVariable = 1;
			Resource sharedResource = new Resource(1);
			methodTwo();
		}

		private void methodTwo() {
			Integer localVariable = new Integer(99);
		}
	}

	private static class Resource {
		private Resource r2, r4;
		private int resourceId;

		public Resource(Resource argR2, Resource argR4) {
			this.r2 = argR2;
			this.r4 = argR4;
		}

		public Resource(int argResourceId) {
			this.resourceId = argResourceId;
		}

	}

}
