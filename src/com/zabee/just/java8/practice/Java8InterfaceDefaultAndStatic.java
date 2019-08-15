package com.zabee.just.java8.practice;
import java.util.function.*;

public class Java8InterfaceDefaultAndStatic {

	interface IWork{
		default public String doWork() {
			System.out.println("Don't be lazy do the following quality work fast!!");
			return "done!!";
		}
		
		static public void doSameWorkForAll(String argWork) {
			System.out.println("Don't be lazy do same work for all");
		}
	}
	
	static class  Work implements IWork{
		
		@Override
		public String doWork() {
			System.out.println("Some work at concrete class");
			return "Done!!";
		}
		
		public String doWork(int x) {
			return "";
		}
		
		public int doWork(int x, int y) {
			return 0;
		}
		 
	}
	public static void main(String[] args) {
		Consumer<String> cons = IWork::doSameWorkForAll;
		cons.accept("Work2");

		Supplier<Work> workInstance = Work::new;
		workInstance.get().doWork();
		
		System.out.println("Before last print");
		Function<Work, String> cons2 = Work::doWork;
		cons2.apply(workInstance.get());
	}

}
