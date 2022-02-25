import java.util.function.UnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class UnaryBinaryOperatorDemo{
  
  public static void main(String []args){
    UnaryOperator<Integer> unaryOperator = x -> x + 10;
    Integer result = unaryOperator.apply(10);
    System.out.println(result);
    
    IntUnaryOperator intUnaryOperator = x -> x + 10;
    result = intUnaryOperator.applyAsInt(10);
    System.out.println(result);
    
    LongUnaryOperator longUnaryOperator = x -> x + 10l;
    long resultLong = longUnaryOperator.applyAsLong(10l);
    System.out.println(resultLong);
    
    DoubleUnaryOperator doubleUnaryOperator = x -> x + 10.0;
    double resultDbl = doubleUnaryOperator.applyAsDouble(10.0);
    System.out.println(resultDbl);
    
    BinaryOperator<String> binaryOperator = (x, y) -> x.concat(y);
    String resultStr = binaryOperator.apply("Zabee " , "Ulla");
    System.out.println(resultStr);
    
    IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
    int r1 = intBinaryOperator.applyAsInt(10 , 20);
    System.out.println(r1);
    
    LongBinaryOperator longBinaryOperator = (x, y) -> x+y;
    long r2 = longBinaryOperator.applyAsLong(1l, 2l);
    System.out.println(r2);
    
    
    DoubleBinaryOperator doubleBinaryOperator = (x, y) -> x + y;
    double r3 = doubleBinaryOperator.applyAsDouble(1.0, 2.0);
    System.out.println(r3);
    
  }
}

/** Output
        20
        20
        20
        20.0
        Zabee Ulla
        30
        3
        3.0
**/
