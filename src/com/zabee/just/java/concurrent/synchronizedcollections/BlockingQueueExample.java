

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<String> itemsQueue = new ArrayBlockingQueue<>(10);
		new Thread(new Producer(itemsQueue)).start();
		new Thread(new Consumer(itemsQueue)).start();

	}

	private static class Producer implements Runnable {
		BlockingQueue<String> itemsQueue;

		public Producer(BlockingQueue<String> argItemsQueue) {
			itemsQueue = argItemsQueue;
		}

		@Override
		public void run() {
			try {
				itemsQueue.put("Water");
			
				itemsQueue.put("Toothpaste");
			
				itemsQueue.put("Toothbrush");
			
				itemsQueue.put("Soap");
			
				itemsQueue.put("Shampoo");
			
				itemsQueue.put("Towel");
			
				itemsQueue.put("Perfume");
			
				itemsQueue.put("Clothes");
			
				itemsQueue.put("Footwear");
			
				itemsQueue.put("Bike");
			
				itemsQueue.put("Road");
			
				itemsQueue.put("Traffic");
			
				itemsQueue.put("Office");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static class Consumer implements Runnable {
		BlockingQueue<String> itemsQueue;

		public Consumer(BlockingQueue<String> itemsQueue2) {
			itemsQueue = itemsQueue2;
		}

		@Override
		public void run() {
			while (!itemsQueue.isEmpty()) {
				System.out.println("Consuming: " + itemsQueue.remove());
			}
		}
	}
}
/** Output
    Consuming: Water
    Consuming: Toothpaste
    Consuming: Toothbrush
    Consuming: Soap
    Consuming: Shampoo
    Consuming: Towel
    Consuming: Perfume
    Consuming: Clothes
    Consuming: Footwear
    Consuming: Bike
    Consuming: Road
    Consuming: Traffic
    Consuming: Office
 **/
