
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
	CompletableFuture is used for asynchronous programming in Java.
	Asynchronous programming is a means of writing non-blocking code
	by running a task on a separate thread than the main application 
	thread and notifying the main thread about its progress, 
	completion or failure
**/
public class CompletableFutureExample {
	
	private static ExecutorService execService = null;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
	    
		CompletableFuture<Integer> completableFuture = calculateThisAsyncly(20);
		
		while (!completableFuture.isDone()) {
			System.out.println("Cacluation is in porcess. Please wait..");
			Thread.sleep(100);
		}
		System.out.println("The output is : " + completableFuture.get());
		execService.shutdown();
	}

	public static CompletableFuture<Integer> calculateThisAsyncly(int argNumber) {
		CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

		execService = Executors.newCachedThreadPool();
		execService.submit(//
				                () -> {
					                    try { Thread.sleep(1000);} 
					                    catch (InterruptedException e) {e.printStackTrace();}
					                    completableFuture.complete(Stream.iterate(0, i -> ++i)//
						                                                 .limit(argNumber)//
							                                             .reduce(0, Integer::sum));//
				                        }
				        );//
		return completableFuture;
	}
}

/** Output
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    Cacluation is in porcess. Please wait..
    The output is : 190
**/
