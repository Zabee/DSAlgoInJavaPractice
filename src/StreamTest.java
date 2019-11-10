import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) {
		List<String> people = Arrays.asList("Zabee", "None");
		people.stream().limit(Integer.valueOf(BigInteger.ZERO.toString())).forEach(person -> System.out.println(person));
	}

}
