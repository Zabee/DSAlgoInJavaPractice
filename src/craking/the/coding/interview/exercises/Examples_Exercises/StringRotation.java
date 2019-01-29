package craking.the.coding.interview.exercises.Examples_Exercises;

public class StringRotation {

	public static void main(String[] args) {
		boolean isRotation = isRotation("waterbottle", "erbottlewat");
		if (isRotation) {
			System.out.println("Given string is roation of original");
		} else {
			System.out.println("Given string is NOT roation of original");
		}

	}

	private static boolean isRotation(String s1, String s2) {
		if (s1.length() > 0 && s1.length() == s2.length()) {
			String s1s1 = s1 + s1;
			return s1s1.indexOf(s2) != -1;

		}
		return false;
	}

}
