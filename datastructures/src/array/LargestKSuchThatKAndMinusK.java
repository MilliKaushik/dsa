package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//https://algo.monster/problems/largest_k_positive_and_negative
public class LargestKSuchThatKAndMinusK {

	public static int largestK(List<Integer> nums) {
		PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negatives = new PriorityQueue<>();

		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) > 0)
				positives.add(nums.get(i));
			else if (nums.get(i) < 0)
				negatives.add(nums.get(i));
		}
		while (!positives.isEmpty() && !negatives.isEmpty()) {
			int p = positives.peek();
			int n = negatives.peek();
			if (p - Math.abs(n) == 0)
				return p;
			else if (p > Math.abs(n))
				positives.remove();
			else
				negatives.remove();
		}
		return 0;
	}

	// best solution - though check if it works - but Set will work
	public static int largestNum(int[] nums) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(-nums[i]);
			if (set.contains(nums[i])) {
				res = Math.max(res, Math.abs(nums[i]));
			}
		}
		return res;
	}

	// solution 2
	public static int largestK2(List<Integer> nums) {
		Map<Integer, Integer> posToNeg = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			if (posToNeg.containsKey(nums.get(i)) || (nums.get(i) == 0))
				continue;
			else if (posToNeg.containsKey(-nums.get(i))) {
				if (max < Math.abs(nums.get(i))) {
					max = Math.abs(nums.get(i));
					posToNeg.remove(-nums.get(i));
				}
			} else
				posToNeg.put(nums.get(i), 0);
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}

}
