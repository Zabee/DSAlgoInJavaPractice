@FunctionalInterface
interface IInterface{
    public int incrementThis(int x);
}

//No need of @FunctionalInterface annotation. By default it is if interface has single method.
interface JInterface{
    public void printThis(int x);
}
public class LambdaDemo {
    public static void main(String args[]) {
      IInterface incrementer = (c) -> c = c+10;
      int result = incrementer.incrementThis(10);
      
      JInterface printer = (c) -> System.out.println("Result is : " + c);
      printer.printThis(result);
    }
}
/** Output
    Result is : 20
**/
