package threads;
public class SleepAndInterrupt {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread("One");
		MyThread t2 = new MyThread("Two");

		MyThread t3 = new MyThread("Three");
		MyThread t4 = new MyThread("Four");

		t1.start();
		t2.start();
		System.out.println("Let's wake up One and Two after 2 seconds");
		Thread.sleep(2000);
		t1.interrupt();
		t2.interrupt();

		t3.start();
		t4.start();
		Thread.sleep(1000);
		System.out.println("Let's wake up Three and Four after 2 seconds");
		Thread.sleep(2000);
		t3.interrupt();
		t4.interrupt();
	}

}

class MyThread extends Thread {
    private String name;
    
    public MyThread(String name){
        this.name = name;
    }
    
	@Override
	public void run() {
		try {
				Thread.sleep(100000);
		} catch (InterruptedException e) {
			System.out.println("Haha, thread interruped and woke up: " + name);
		}
	}
}

/** Output
	Let's wake up One and Two after 2 seconds
	Haha, thread interruped and woke up: One
	Haha, thread interruped and woke up: Two
	Let's wake up Three and Four after 2 seconds
	Haha, thread interruped and woke up: Three
	Haha, thread interruped and woke up: Four
**/
