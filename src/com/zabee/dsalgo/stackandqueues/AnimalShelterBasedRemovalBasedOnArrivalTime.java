package com.zabee.dsalgo.stackandqueues;

import java.util.LinkedList;

public class AnimalShelterBasedRemovalBasedOnArrivalTime {

	public static void main(String[] args) {
		AnimalShelter animalShelter = new AnimalShelter();
		animalShelter.enqueue(new Dog("ADog"));
		animalShelter.enqueue(new Cat("ACat"));
		animalShelter.enqueue(new Dog("BDog"));
		animalShelter.enqueue(new Dog("CDog"));
		animalShelter.enqueue(new Dog("DDog"));
		animalShelter.enqueue(new Dog("EDog"));
		animalShelter.enqueue(new Dog("FDog"));
		animalShelter.enqueue(new Dog("GDog"));
		animalShelter.enqueue(new Dog("HDog"));
		animalShelter.enqueue(new Cat("BCat"));
		animalShelter.enqueue(new Cat("CCat"));
		animalShelter.enqueue(new Cat("DCat"));
		animalShelter.enqueue(new Dog("IDog"));
		animalShelter.enqueue(new Cat("ECat"));
		animalShelter.enqueue(new Cat("FCat"));
		animalShelter.enqueue(new Dog("JDog"));
		animalShelter.enqueue(new Dog("KDog"));
		animalShelter.enqueue(new Cat("GCat"));
		animalShelter.enqueue(new Cat("HCat"));
		animalShelter.enqueue(new Dog("LDog"));
		
		System.out.println("Remove any :" +   animalShelter.dqueueAny());
		System.out.println("Remove any :" +   animalShelter.dqueueAny());
		System.out.println("Remove any :" +   animalShelter.dqueueAny());
		System.out.println("Remove any :" +   animalShelter.dqueueAny());
		
		System.out.println("Remove Dog :" +   animalShelter.dqueueDog());
		System.out.println("Remove Cat :" +   animalShelter.dqueueCat());
		
		
	}
}

class AnimalShelter {
	private final LinkedList<Dog> dogs = new LinkedList<>();
	private final LinkedList<Cat> cats = new LinkedList<>();
	private static int order;

	public void enqueue(Animal anAnimal) {
		this.order++;
		anAnimal.setOrder(order);
		if (anAnimal instanceof Dog) {
			dogs.addLast((Dog) anAnimal);
		} else {
			cats.addLast((Cat) anAnimal);
		}
	}

	public Animal dqueueAny() {
		if (dogs.size() == 0) {
			return cats.remove();
		} else if (cats.size() == 0) {
			return dogs.remove();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dogs.remove();
		}
		return cats.remove();
	}

	public Animal dqueueDog() {
		return dogs.poll();
	}

	public Animal dqueueCat() {
		return cats.poll();
	}

}

abstract class Animal {
	private String name;
	private int order;

	public Animal(final String argName) {
		name = argName;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(final int argOrder) {
		this.order = argOrder;
	}

	public boolean isOlderThan(Animal anAnimal) {
		return this.order < anAnimal.getOrder();
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\tOrder:" + order;
	}
}

class Dog extends Animal {
	public Dog(String argName) {
		super(argName);
	}
}

class Cat extends Animal {
	public Cat(String argName) {
		super(argName);
	}
}