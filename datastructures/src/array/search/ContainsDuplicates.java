package array.search;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
public class ContainsDuplicates {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
