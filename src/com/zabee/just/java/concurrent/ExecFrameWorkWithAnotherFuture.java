import java.util.concurrent.*;
public class ExecFrameWorkWithAnotherFuture{
	
	public static void main(String []args) throws InterruptedException, ExecutionException{
		SquareCalculator sc = new SquareCalculator();
		Future<Long> future = sc.calculateSquare(4);
		System.out.println("The square value of 4 is : " + future.get());
		future.shutdown();
	}
}

class SquareCalculator{
	private ExecutorService execService = Executors.newSingleThreadExecutor();
	
	public Future<Long> calculateSquare(int input){
		return execService.submit(
			() -> {
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){
				}
				return Long.valueOf(input * input);
			}
		);
	}//End of method
}