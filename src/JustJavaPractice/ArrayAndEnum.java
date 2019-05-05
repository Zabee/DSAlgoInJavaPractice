package justJavaPractice;

public class ArrayAndEnum {
	final static int x = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int[] priceArray = { 1, 2, 3, 4, 5, 6 };
//			int [] priceArray2 = Arrays.copyOf(priceArray, priceArray.length);	//This is purely new copy, new place in memory, change of one will not affect in other
			int[] priceArray2 = priceArray; // Just adds a pointer/reference to the original array, so any changes of
											// either of them reflect in another
			System.out.println(priceArray);
			System.out.println(priceArray2);
			priceArray2[0] = 0;
			for (int x : priceArray) {
				System.out.println(x);
			}
			for (int x : priceArray2) {
				System.out.println(x);
			}
			System.out.println("Ordinal i.e. the position:\"" + Constants.ONE.ordinal() + "\"");
			System.out.println("Name i.e. kind of a key:\"" + Constants.TWO + "\"");
			System.out.println("Value associated with the kind of a key i.e. the member variable of ENUM:\""
					+ Constants.THREE.someX + "\"");
			System.out.println("Value associated with the kind of a key i.e. the member variable of ENUM:\""
					+ Constants.FOUR.someX + "\"");
			System.out.println("Print this inside try");
			System.out.println("Print this again inside try");
		} finally {
			System.out.println("Okay PRINT now");
		}
		System.out.println("Print again outside finally");
	}

}
