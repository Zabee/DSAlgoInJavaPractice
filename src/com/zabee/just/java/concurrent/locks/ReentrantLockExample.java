package threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class ReentrantLockExample {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock reentrantLock = new ReentrantLock(true);

		// Let's add 0 to 9 integers to resourceQueue
		ConcurrentLinkedQueue<Integer> resourceQueue = new ConcurrentLinkedQueue<>();
		Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> resourceQueue.add(i));
		System.out.print("Input        :");
		resourceQueue.forEach(i -> System.out.print("\t" + i));
		System.out.println();
		ExecutorService workerThreadsexecService = Executors.newFixedThreadPool(6);
		// The beauty is that every thread clears the shared queue and adds back the values to it synchronously.
		// No disruption nothing. The final output is same as the original input i.e. 0 to 9 integers in the shared, main queue.
		MyWorkerThread myWorkerThread1 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread2 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread3 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread4 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread5 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread6 = new MyWorkerThread(reentrantLock, resourceQueue);

		List<MyWorkerThread> workers = Arrays.asList(myWorkerThread1, myWorkerThread2, myWorkerThread3, myWorkerThread4,
				myWorkerThread5, myWorkerThread6);
		workers.forEach(worker -> workerThreadsexecService.submit(worker));
		for (MyWorkerThread worker : workers) {
			worker.join(); // This main waits until all the worker threads finish their execution
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
		System.out.print("Final Output :");
		resourceQueue.forEach(i -> System.out.print("\t" + i));
		workerThreadsexecService.shutdown();
	}

	private static class MyWorkerThread extends Thread {
		private final ReentrantLock reentrantLock;
		private final ConcurrentLinkedQueue<Integer> thisResourceQueue;

		private MyWorkerThread(final ReentrantLock argReentrantLock,
				final ConcurrentLinkedQueue<Integer> argResourceQueue) {
			this.thisResourceQueue = argResourceQueue;
			reentrantLock = argReentrantLock;
		}

		@Override
		public void run() {
			try {
				reentrantLock.lock();
				ConcurrentLinkedQueue<Integer> myQueue = new ConcurrentLinkedQueue<>();
				// Copy the values to my local queue
				thisResourceQueue.forEach(i -> myQueue.add(i));
				// Clear the shared, main Queue
				thisResourceQueue.clear();
				// Add back the local queue values to shared, main Queue
				myQueue.forEach(i -> thisResourceQueue.add(i));
			} finally {
				reentrantLock.unlock();
			}

		}
	}
}

/** Output
	Input        :	0	1	2	3	4	5	6	7	8	9
	Final Output :	0	1	2	3	4	5	6	7	8	9
**/
