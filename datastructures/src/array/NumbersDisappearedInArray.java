package array;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class NumbersDisappearedInArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		List<Integer> disappearedNumbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

		for (int i = 0; i < n; i++) {
			int current = getCurrentElement(nums[i], n);
			nums[current - 1] += n;
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] >= n)
				disappearedNumbers.remove(i + 1);
		}
		return disappearedNumbers;
	}

	private int getCurrentElement(int element, int n) {
		if (element < n)
			return element;
		while (element > n)
			element -= n;
		return element;
	}
}
