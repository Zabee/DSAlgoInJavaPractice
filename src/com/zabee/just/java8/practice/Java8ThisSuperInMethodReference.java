package com.zabee.just.java8.practice;
import java.util.function.*;

class Super{
	
	public void doThisSuperly(String argStr) {
		System.out.println("What's up kid. I am super man." + argStr);
	}
	
}

class Sub extends Super{
	public String doThis(String argStr) {
		System.out.println("After done calling super man" + argStr);
		Consumer<String> superCons = super::doThisSuperly;
		Consumer<String> thisCons = this::anotherThing;
		thisCons.accept(argStr);
		superCons.accept(argStr);
		return "";
	}
	
	public void anotherThing(String argStr) {
		System.out.println("Another thing thong!!" + argStr);
	}
	
}
public class Java8ThisSuperInMethodReference {

	public static void main(String []args) {
		Supplier<Sub> subSupplier = Sub::new;
		Sub sub = subSupplier.get();
		Function<String, String> cons =  sub::doThis;
		cons.apply("Show me");
		Function<Integer, Long> func = Integer::longValue;
		System.out.println(func.apply(10));
	}
}
