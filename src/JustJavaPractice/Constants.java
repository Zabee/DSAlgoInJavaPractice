package practice.concepts;

/**
 * Enum is like MAP.
 * The Enum members are keys and member variable is value
 * 
 * Key will always be the name of Enum for e.g. ONE in this case
 * ordinal() method gives the position of the Enum 
 * For e.g. ONE.someX give the value associated with the key
 * 
 * @author Zabee
 *
 */
public enum Constants {
	ONE("1"), TWO("20"), THREE("30"), FOUR("FOUR THIS IS VALUE");
//	ONE, TWO, THREE;

	String someX;
	/**
	 * Constructs a <code>Constants</code>.
	 * 
	 */
	private Constants(String x) {
		someX = x;
	}
}
