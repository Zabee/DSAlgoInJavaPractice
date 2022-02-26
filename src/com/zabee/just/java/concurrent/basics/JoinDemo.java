package threads;

public class JoinDemo {

	static Thread thread1 = new Thread() {
		@Override
		public void run() {
			// SEE HERE, INFINITE LOOP
			for (;;) {
				System.out.println("My thread1!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	};

	static Thread thread2 = new Thread() {
		@Override
		public void run() {
			System.out.println("My thread2!!");
		}
	};

	static Runnable threadRunnable3 = new Runnable() {
		@Override
		public void run() {
			System.out.println("My thread3!! Runnable one");
		}
	};

	static class MyThreadRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("My thread4!! External runnable implemented one");
		}
	}

	static class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("My thread5!! External implemented one");
		};
	}

	static Thread thread3Wrapper = new Thread(threadRunnable3);

	static MyThreadRunnable myThreadRunnable4 = new MyThreadRunnable();
	static Thread thread4Wrapper = new Thread(myThreadRunnable4);

	static MyThread myThread5 = new MyThread();

	public static void main(String[] args) {
		System.out.println("Entered main and then sleeping for 100 milli seconds");
		try {

			Thread.sleep(100);

			thread1.start();
			thread1.interrupt();

			thread2.start();
			thread3Wrapper.start();
			thread4Wrapper.start();
			thread4Wrapper.join(); // This main thread Waits until thread 4 completes.
			myThread5.start();

			if (thread1.isAlive()) {
				System.out.println("Thread 1 is alive");
				thread1.interrupt();
				thread1.join(); // This main thread Waits until thread1 completes. Comment and Uncomment this to see it working
			}
			System.out.println("**********End of main thread"); // Never reaches here! if thread1.join() uncommented
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
