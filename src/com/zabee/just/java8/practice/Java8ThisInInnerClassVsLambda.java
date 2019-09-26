package com.zabee.just.java8.practice;

import java.util.function.Supplier;

public class Java8ThisInInnerClassVsLambda {

	public static void main(String []args) {
		String str = "Abhi";
		//Anti - pattern ahead
		Supplier<String> sup = () -> {
			return str;
		};
		System.out.println(Foo.staticFoo());
		FooClass fooObject = new FooClass() {
		};
		System.out.println(fooObject.foo());
		System.out.println(fooObject.defaultFoo());
		
	}
}

abstract class FooClass implements Foo{
	@Override
	public String foo() {
		return "Foo from Foo Class";
	}
	
	@Override
	public String defaultFoo() {
		Foo.super.defaultFoo();
		return "Foo from Foo Class";
	}

	public String staticFoo() {
		return "Static Foo from Foo Class";
	}
}


@FunctionalInterface
interface Foo{
	String foo();
	
	static String staticFoo() {
		return "Static Foo";
	}
	default String defaultFoo() {
		return "Default Foo";
	}
	
	
}