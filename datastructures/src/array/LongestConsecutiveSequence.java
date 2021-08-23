package array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/
//https://www.interviewbit.com/problems/longest-consecutive-sequence/
//https://leetcode.com/problems/longest-consecutive-sequence/solution/
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int len, max = 0;
		for (int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		for (int a : set) {
			if (!set.contains(a - 1)) {
				len = 1;
				int curr = a;
				while (set.contains(curr + 1)) {
					len++;
					curr++;
				}
				max = Math.max(len, max);
			}
		}
		return max;
	}
}