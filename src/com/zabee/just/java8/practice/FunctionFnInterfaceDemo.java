import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.DoubleFunction;

public class FunctionFnInterfaceDemo {

    public static void main(String[] args) {
       Function<Integer, Integer> fn = (x) -> x+10;
       int result = fn.apply(10);
       System.out.println(result);
       
       BiFunction<Integer, Integer, Integer> bfn = (x, y) -> x+y;
       result = bfn.apply(10, 20);
       System.out.println(result);
       
       //Argument is Integer and Retrun Type is also <Integer>
       IntFunction<Integer> ifn = (x) -> x+10;
       result = ifn.apply(10);
       System.out.println(result);
       
       //Argument is Long and Retrun Type is <Integer>
       LongFunction<Integer> lfn = (x) -> 10;
       result = lfn.apply(10l);
       System.out.println(result);
       
       //Argument is Double and Retrun Type is also <Integer>
       DoubleFunction<Integer> dfn = (x) -> 10;
       result = dfn.apply(10.0);
       System.out.println(result);
    }
}

/** Output
        20
        30
        20
        10
        10
**/
