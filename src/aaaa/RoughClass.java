package aaaa;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoughClass {

	public static void main(String[] args) throws Exception {
		Stream<String> names = Stream.of("Zabee", "Ulla", "Khan");
		List<String> nameList = names.collect(Collectors.toList());
		String[] arrNames = {"Zabee", "Ulla"};
		// ========================================================
		List<Employee> employees = Stream.iterate(0, i -> ++i)//
				.map(i -> new Employee(i, "Name " + i))//
				.limit(10)//
				.collect(Collectors.toList());//

		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).eno = i;
			employees.get(i).ename = employees.get(i).ename.toUpperCase();
		}
		employees.forEach(System.out::println);

		System.out.println("After upper casing");
		employees = employees.stream().map(RoughClass::upperCaseMe).collect(Collectors.toList());
		employees.stream().forEach(System.out::println);

		Map<String, List<Employee>> ageNameMap = employees.stream()//
				.collect(Collectors.groupingBy(Employee::toString));

		System.out.println("Don't regret");
	}

	private static Employee upperCaseMe(Employee emp) {
		emp.ename = emp.ename.toUpperCase();
		return emp;
	}

	private static class Employee {
		private static int eno;
		private static String ename;

		public Employee(int eno, String ename) {
			this.eno = eno;
			this.ename = ename;
		}

		public String toString() {
			return eno + " | " + ename;
		}
	}
}
