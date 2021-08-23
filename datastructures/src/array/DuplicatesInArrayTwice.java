package array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class DuplicatesInArrayTwice {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i] < 0 ? nums[i] * -1 : nums[i];
			if (nums[a - 1] < 0) {
				duplicates.add(a);
				continue;
			}
			nums[a - 1] *= -1;
		}
		return duplicates;
	}

}
