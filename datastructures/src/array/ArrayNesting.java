package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/array-nesting/
//https://leetcode.com/problems/array-nesting/solution/
public class ArrayNesting {

	// TLE
	public int arrayNesting1(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int current = nums[i];
			set = new HashSet<>();
			while (true) {
				if (set.contains(current))
					break;
				set.add(current);
				current = nums[current];
			}
			max = Math.max(set.size(), max);
		}
		return max;
	}

	// using extra space
	public int arrayNesting2(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			count = 0;
			int current = nums[i];
			int start = current;
			do {
				count++;
				visited[current] = true;
				current = nums[current];
			} while (current != start);
			max = Math.max(count, max);
		}
		return max;
	}

	public int arrayNesting3(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0)
				continue;
			count = 0;
			int current = nums[i];
			int index = i;
			int start = current;
			do {
				count++;
				nums[index] *= -1;
				index = current;
				current = Math.abs(nums[current]);
			} while (current != start);
			max = Math.max(count, max);
		}
		return max;
	}
}
