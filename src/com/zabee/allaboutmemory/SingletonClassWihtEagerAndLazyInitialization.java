package com.zabee.allaboutmemory;

/**
 * One of memory issues where we use static members. The static members clings
 * to the life cycle of class and hence stays in Heap memory for very long time.
 * So be cautions and think twice before making field static.
 * 
 */
public class SingletonClassWihtEagerAndLazyInitialization { 

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Let's load eager singleton class");
		EagerSingletonClass eagerSingletonClass = EagerSingletonClass.getInstance();
		System.out.println(eagerSingletonClass);
		System.out.println("Let's load lazy singleton class");
		LazySingletonClass lazySingletonClass = LazySingletonClass.getInstance();
		System.out.println(lazySingletonClass);
	}

}

class EagerSingletonClass {
	private static EagerSingletonClass eagerSingletonClass = new EagerSingletonClass();

	private EagerSingletonClass() {
	}

	public static EagerSingletonClass getInstance() {
		return eagerSingletonClass;
	}
	
	public String toString() {
		return "EagerSingletonClass";
	}
}

class LazySingletonClass {
	// static cannot be avoided here but it can be lazy so that we can postpone its
	// loading to heap to little later memory cycles
	private static LazySingletonClass lazySingletonClass = null;

	private LazySingletonClass() {
	}

	public static LazySingletonClass getInstance() {
		if (lazySingletonClass == null) {
			lazySingletonClass = new LazySingletonClass();
		}
		return lazySingletonClass;
	}
	public String toString() {
		return "LazySingletonClass";
	}
}
