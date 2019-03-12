import java.util.HashMap;
import java.util.Map;

/**
 * https://www.eclipse.org/community/eclipse_newsletter/2017/june/article1.php
 * 
 * (1) Watch Points: for global Variables 
 * (2) Trace Points: for local Variables
 * or whatever reason, alternative of printing sysout() custome messages - I am
 * here. Inside if condition etc., 
 * (3) Conditional Break point
 * (4) Trigger point: Even if there are some breakpoint at n-x lines but you want to start
 * from 'n'th line 
 * (5) Exception breakpoint
 *
 * (6) GroupBy or SortBy break points 
 * (7) Show logical structure in variables so that internal structure is hidden 
 * (8) Method's return value can be seen in Variables section 
 * (9) Group multiple launchers and can be executed serially one by one automatically
 * 
 * @author Zabee
 *
 */
public class AdvancedDebugDemo {

	// Added a watch point here. Looks like it is meant for global Variables only
	private static int y = 10;

	public static void main(String[] args) {
		// Normal Break Point
		int x = 0;

		// Condition Break Point - upon satisfying specified condition, hit the
		// breakpoint
		x = 10;

		// Watch Point - whenever value of x or any variable changes, hit the breakpoint
		// So, now if you press F8 or whatever it halts at every modification of y and
		// its usage/access. This can be changed to halt at modification from its
		// breakpoint properties
		y++;

		System.out.println("y value is : " + y);
		x = y + 10;

		y++;
		System.out.println("y value is : " + y);

		y--;
		System.out.println("y value is : " + y);

		Map<Integer, String> rollNumbers = new HashMap<>();
		rollNumbers.put(1, "Abc");
		rollNumbers.put(2, "Efg");
		rollNumbers.put(3, "bdc");
		rollNumbers.put(4, "zbc");
		rollNumbers.put(5, "pbc");

		// Method result printed in Varibles section after its call
		int result = add(10, 20);

		// Exception Break Point - whenever any specified exception occurs, hit the
		// breakpoint
		String s = null;
		s.toString();
		s = s.concat("");
		s = s.trim();
	}

	private static int add(int x, int y) {
		return x + y;
	}

}
