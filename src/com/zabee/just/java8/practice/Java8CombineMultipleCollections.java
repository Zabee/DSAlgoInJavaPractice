package com.zabee.just.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8CombineMultipleCollections {
	private static Order fruitsOrder = new Order(1);
	private static Order veggiesOrder = new Order(2);
	private static Order personalCareOrder = new Order(3);
	
	static {
		fruitsOrder.buildOrder("Apple", 10)//
		.buildOrder("Grapes", 8)//
		.buildOrder("Banana", 4);
		
		veggiesOrder.buildOrder("Tomato", 2)//
		.buildOrder("Potato", 2)//
		.buildOrder("Beet Root", 2);
		
		personalCareOrder.buildOrder("Shampoo", 1)//
		.buildOrder("Soap", 2)//
		.buildOrder("Perfume", 3);
	}
	private static void streamDotConcatExample() {
		
		
		Stream<Entry<String, Double>> interMediateOrders = Stream.concat(fruitsOrder.items.entrySet().stream(), veggiesOrder.items.entrySet().stream());
		interMediateOrders = Stream.concat(interMediateOrders, personalCareOrder.items.entrySet().stream());
		
		double totalPayment = interMediateOrders.mapToDouble(entry -> entry.getValue()).sum();
		System.out.println("Total payment through streamDotConcat:" + totalPayment);
	}
	
	private static void streamInstanceMethodFlatMapExample() {
		double totalPayment = Stream.of(fruitsOrder, veggiesOrder, personalCareOrder)//
				.flatMap(order -> order.items.entrySet().stream())//
				.mapToDouble(entrySet -> entrySet.getValue())//
				.sum();
		System.out.println("Total payment through streamInstanceMethodFlatMapExample:" + totalPayment);
	}
	
	public static void main(String[] args) {
		streamDotConcatExample();
		streamInstanceMethodFlatMapExample();
		
		List<String> collection1 = Arrays.asList("My ", "name ", "is ");
		List<String> collection2 = Arrays.asList("Zabee ", "Ulla ");
		List<String> collection3 = Arrays.asList("So", " what ", "is ", "your ", "name?");
		collection1.stream().flatMap(c -> collection2.stream()).forEach(System.out::println);
		
		List<String> combined = Stream.concat(collection1.stream(), collection2.stream()).collect(Collectors.toList());
		combined = Stream.concat(combined.stream(), collection3.stream()).collect(Collectors.toList());
		System.out.println(combined);

		List<List<String>> listOfList = Arrays.asList(collection1, collection2, collection3);
		combined = listOfList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(combined);

	}
	private static class Order{
		private Map<String, Double> items = new HashMap<>();
		private int orderNum;
		
		private Order(final int orderNum) {
			this.orderNum = orderNum;
		}
		
		private Order buildOrder(String item, double price) {
			items.put(item, price);
			return this;
		}
	}
}