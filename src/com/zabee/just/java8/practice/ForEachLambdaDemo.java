import java.util.*;

public class ForEachLambdaDemo {

  public static void main(String[] args) {
	List<Integer> nums = new ArrayList<>();
    nums.add(1);
    nums.add(2);
    nums.add(3);
    nums.add(4);
    nums.add(5);
    nums.forEach((x) -> System.out.print(x + "\t"));
  }
}

/** Output
  1	2	3	4	5
**/
