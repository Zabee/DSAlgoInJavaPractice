import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.DoublePredicate;

public class PredicateFnInterfaceDemo {

    public static void main(String[] args) {
       Predicate<String> predicate = x -> x != null;
       boolean result = predicate.test("Zabee");
       System.out.println(result);
       
       BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
       result = biPredicate.test("Zabee", "Zabee");
       System.out.println(result);
       
       IntPredicate intPredicate = x -> x != 0;
       result = intPredicate.test(10);
       System.out.println(result);
       
       LongPredicate longPredicate = x -> x > 100;
       result = longPredicate.test(101);
       System.out.println(result);
       
       DoublePredicate doublePredicate = x -> x > 0.1;
       result = doublePredicate.test(0.2);
       System.out.println(result);
    }
}

/** Output
        true
        true
        true
        true
        true
**/
