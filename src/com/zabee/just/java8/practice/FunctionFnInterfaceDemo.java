import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.DoubleFunction;
import java.util.stream.*;

public class FunctionFnInterfaceDemo {

    public static void main(String[] args) {
        //      ReturnType, Argument
       Function<Integer, Integer> fn = (x) -> x+10;
       int result = fn.apply(10);
       System.out.println(result);
       
        //      ReturnType, Argument1, Argument2
       BiFunction<Integer, Integer, Double> bfn = (x, y) -> Double.valueOf(x+y);
       double resultDbl = bfn.apply(10, 20);
       System.out.println(resultDbl);
       
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
        
        
      BiFunction<String, String, String[]> strSplit = (s, d) -> s.split(d);
      String[] res = strSplit.apply("Muhammad:Zabee:Ulla", ":");
        Stream.iterate(0, i-> i+1)
                .limit(res.length)
                .map(i -> res[i])
                .forEach(System.out::println);
    }
}

/** Output
        20
        30.0
        10.0
        10
        10
        Muhammad
        Zabee
        Ulla
**/
