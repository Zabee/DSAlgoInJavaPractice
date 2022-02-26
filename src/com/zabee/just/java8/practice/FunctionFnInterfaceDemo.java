import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.DoubleFunction;

public class FunctionFnInterfaceDemo {

    public static void main(String[] args) {
        //      ReturnType, Argument
       Function<Integer, Integer> fn = (x) -> x+10;
       int result = fn.apply(10);
       System.out.println(result);
       
        //      ReturnType, Argument1, Argument2
       BiFunction<Integer, Integer, Integer> bfn = (x, y) -> x+y;
       result = bfn.apply(10, 20);
       System.out.println(result);
       
       //Argument is Integer and Retrun Type is <Double>
       IntFunction<Double> ifn = (x) -> 10.0;
       double resultD = ifn.apply(10);
       System.out.println(resultD);
       
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
        10.0
        10
        10
**/
