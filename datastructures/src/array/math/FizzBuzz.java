package array.math;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/
public class FizzBuzz {
	private final static String FIZZBUZZ = "FizzBuzz";
	private final static String FIZZ = "Fizz";
	private final static String BUZZ = "Buzz";

	public List<String> fizzBuzz(int n) {
		List<String> ans = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				ans.add(FIZZBUZZ);
			else if (i % 3 == 0)
				ans.add(FIZZ);
			else if (i % 5 == 0)
				ans.add(BUZZ);
			else
				ans.add(String.valueOf(i));
		}
		return ans;
	}
}
