import java.util.concurrent.*;

public class ExecFrameWorkWithFuture{
	public static void main(String []args) throws ExecutionException, InterruptedException {
		ExecutorService execService = Executors.newFixedThreadPool(4);
		MyWorker worker1 = new MyWorker(3);
		MyWorker worker2 = new MyWorker(4);
		Future<?> futureResult1 = execService.submit(worker1);
		Future<?> futureResult2 = execService.submit(worker2);
		while(!futureResult1.isDone() && !futureResult1.isDone()){
			System.out.println("Waiting for workers to complete...");
		}
		System.out.println("Actually, I could have used execService.awaitTermination(5, TimeUnit.SECONDS)");
		System.out.println("Results are : " + worker1.getSquareOfAGivenNumber() + " and " +  worker2.getSquareOfAGivenNumber());
		execService.shutdown();
	}
}

class MyWorker implements Runnable{
	private final int num;
	private long result;
	
	public MyWorker(int argNum){
		this.num = argNum;
	}
	
	@Override
	public void run(){
		System.out.println("Started to calculated square of a given number with very old hardware config. Please wiat");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		result = num * num;
		System.out.println("Done. See your result");
	}
	
	public long getSquareOfAGivenNumber(){
		return result;
	}
}