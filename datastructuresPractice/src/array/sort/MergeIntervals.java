package array.sort;

import java.util.Arrays;
import java.util.Comparator;

//O(nlogn) time and O(1) space
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[0] > arr2[0])
					return 1;
				else if (arr1[0] == arr2[0])
					return arr1[1] - arr2[1];
				else
					return -1;
			}
		});

		if (n == 1)
			return intervals;
		int k = 0, j = 1;
		while (j < n) {
			if (intervals[k][1] >= intervals[j][0]) {
				intervals[k][0] = Math.min(intervals[k][0], intervals[j][0]);
				intervals[k][1] = Math.max(intervals[k][1], intervals[j][1]);
				j++;
			} else {
				k++;
				intervals[k][0] = intervals[j][0];
				intervals[k][1] = intervals[j][1];
				j++;
			}
		}
		int[][] result = new int[k + 1][2];
		for (int i = 0; i <= k; i++) {
			result[i][0] = intervals[i][0];
			result[i][1] = intervals[i][1];
		}
		return result;
	}
}
