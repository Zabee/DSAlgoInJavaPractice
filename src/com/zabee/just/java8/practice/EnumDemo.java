package com.zabee.just.java8.practice;

import java.util.Comparator;

interface Direction {
	public String showDirection();
}

enum AdvDirection implements Direction {
	EAST {
		@Override
		public String showDirection() {
			// TODO Auto-generated method stub
			return "EAST";
		}
	},
	WEST {
		@Override
		public String showDirection() {
			// TODO Auto-generated method stub
			return "WEST";
		}
	},
	NORTH {
		@Override
		public String showDirection() {
			// TODO Auto-generated method stub
			return "NORTH";
		}
	},
	SOUTH {
		@Override
		public String showDirection() {
			// TODO Auto-generated method stub
			return "SOUTH";
		}
	};
}

enum Days{
	SUNDAY(6), MONDAY(6), TUESDAY(7), WEDNESDAY(9), THURSDAY(8), FRIDAY(6), SATURDAY(8);

	private int numberOfChars;

	private Days(int argNoChars) {
		numberOfChars = argNoChars;
	}

	public int getNumberOfChars() {
		return numberOfChars;
	}

	public void setNumberOfChars(int numberOfChars) {
		this.numberOfChars = numberOfChars;
	}

	public static String uppperCaseUtility(String argDay) {
		return argDay.toUpperCase();
	}
}

public class EnumDemo {
	public static void main(String[] args) {
		AdvDirection advDirection = AdvDirection.SOUTH;
		System.out.println(advDirection.showDirection());
		System.exit(0);
		
		System.out.println("Enum demo");
		System.out.println("Name: " + Days.MONDAY.name());
		System.out.println("Ordinal:" + Days.MONDAY.ordinal());
		System.out.println("Declared Class:" + Days.MONDAY.getDeclaringClass());
		System.out.println("toString: " + Days.MONDAY.toString());
		System.out.println("valueOf:" + Days.MONDAY.valueOf("TUESDAY"));
		whatDayIsToday(Days.MONDAY);
		System.out.println(Days.TUESDAY.compareTo(Days.FRIDAY));

		Comparator<String> nameComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		System.out.println(nameComparator.compare("Ulla", "Zabee"));
	}

	/**
	 * This method doesn't make any sense to a sane developer :D so chill
	 * 
	 * @param day
	 */
	private static void whatDayIsToday(Days day) {
		switch (day) {
		case SUNDAY:
			System.out.println("Tody is " + day);
			break;
		case MONDAY:
			System.out.println("Tody is " + day);
			break;
		case TUESDAY:
			System.out.println("Tody is " + day);
			break;
		case WEDNESDAY:
			System.out.println("Tody is " + day);
			break;
		case THURSDAY:
			System.out.println("Tody is " + day);
			break;
		case FRIDAY:
			System.out.println("Tody is " + day);
			break;
		case SATURDAY:
			System.out.println("Tody is " + Days.uppperCaseUtility(day.name()));
			break;
		default:
			break;

		}
	}
}