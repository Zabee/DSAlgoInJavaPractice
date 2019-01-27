package craking.the.coding.interview.exercises.Examples_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;

public class OneAwayEdit {

	public static void main(String[] args) throws InterruptedException {
		Map<Float, Float> iFMap = new LinkedHashMap<>();
		iFMap.put(1.0f, 1.00f);
		iFMap.put(1.01f, 2.00f);
		
		iFMap.get(1.01f);
	}

}
