
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.DoubleConsumer;
import java.util.*;

public class ConsumerFnInterfaceDemo {
	public static void main(String []args) {
		Consumer<Integer> strConsumer = str -> System.out.print(str + "\t");
		justPrint(strConsumer);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.forEach(strConsumer);
		System.out.println();
		
		//BiConsumer
		BiConsumer<Integer, String> intStrBiConsumer = (x, y) -> System.out.println("BiConsumer: " + x+y);
		intStrBiConsumer.accept(10, "Ten");
		
		//IntConsumer. No need to specify type as the name itself has type
		IntConsumer intConsumer = (x) -> System.out.println("IntConsumer: " + x);
		intConsumer.accept(10);
		
		//LongConsumer. No need to specify type as the name itself has type
		LongConsumer longConsumer = x -> System.out.println("LongConsumer : " + x);
		longConsumer.accept(10);
		
		//DoubleConsumer. No need to specify type as the name itself has type
		DoubleConsumer doubleConsumer = x -> System.out.println("DoubleConsumer : "+ x);
		doubleConsumer.accept(10.20);
	}
	
	private static void justPrint(Consumer<Integer> strConsumer) {
	    System.out.print("Simply printing: ");
		strConsumer.accept(10);
		System.out.println();
	}
}
/** Output
    Simply printing: 10	
    1	2	3	4	5	6	
    BiConsumer: 10Ten
    IntConsumer: 10
    LongConsumer : 10
    DoubleConsumer : 10.2
**/
