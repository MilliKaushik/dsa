package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff))
				return new int[] { i, map.get(diff) };
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum elements found");
	}

	private class Index implements Comparable<Index> {
		private Integer index1;
		private Integer index2;

		public Index(Integer index1, Integer index2) {
			this.index1 = index1;
			this.index2 = index2;
		}

		@Override
		public int compareTo(Index other) {
			int x = Integer.compare(this.index2, other.index2);
			if (x != 0)
				return x;
			return Integer.compare(this.index2, other.index2);
		}
	}

	public ArrayList<Integer> twoSum(final List<Integer> arr, int sum) {
		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(arr);
		int i = 0, j = 0;
		while (i < j) {
			int currSum = arr.get(i) + arr.get(j);
			if (currSum == sum) {
				updateResult(result, arr, i, j);
				i++;
				j--;
			} else if (currSum < sum)
				i++;
			else
				j--;
		}
		return result;
	}

	private void updateResult(ArrayList<Integer> result, List<Integer> arr, int i, int j) {
		if (result.isEmpty() || result.get(1) > j) {
			result.add(i + 1);
			result.add(j + 1);
			return;
		} else {
			if(result.get(1) > j) {}
		}

	}
}
