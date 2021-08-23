package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/3sum/	
public class ThreeSum {

	// sorting O(nlogn) then traversing O(n2)
	public List<List<Integer>> threeSum1(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		sort(nums);
		int n = nums.length;
		int i, j;
		for (int k = 0; k < n; k++) {
			i = k + 1;
			j = n - 1;
			while (i < j) {
				if (nums[k] + nums[i] + nums[j] == 0) {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[k]);
					triplet.add(nums[i]);
					triplet.add(nums[j]);
					result.add(triplet);
					i++;
					j--;
				} else if (nums[k] + nums[i] + nums[j] < 0)
					i++;
				else
					j--;
			}
		}
		return new ArrayList<>(result);
	}

	private void sort(int[] nums) {
		mergesort(nums, 0, nums.length - 1);
	}

	private void mergesort(int[] nums, int st, int end) {
		if (st < end) {
			int mid = st + (end - st) / 2;
			mergesort(nums, st, mid);
			mergesort(nums, mid + 1, end);
			merge(nums, st, mid, end);
		}
	}

	private void merge(int[] nums, int st, int mid, int end) {
		int n1 = mid - st + 1;
		int n2 = end - mid;
		int[] left = new int[n1];
		int[] right = new int[n2];

		int i, j;
		for (i = 0; i < n1; i++)
			left[i] = nums[i + st];
		for (j = 0; j < n2; j++)
			right[j] = nums[j + mid + 1];
		i = 0;
		j = 0;
		int k = st;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j])
				nums[k++] = left[i++];
			else
				nums[k++] = right[j++];
		}
		while (i < n1)
			nums[k++] = left[i++];
		while (j < n2)
			nums[k++] = right[j++];
	}

	// extra space O(n2) time O(n) space - not changing the array
	public List<List<Integer>> threeSum2(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		int n = nums.length;

		Set<Integer> set = new HashSet<>();
		int sum;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum = -(nums[i] + nums[j]);
				if (set.contains(sum)) {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[i]);
					triplet.add(nums[j]);
					triplet.add(sum);
					Collections.sort(triplet);
					result.add(triplet);
				}
			}
			set.add(nums[i]);
		}
		return new ArrayList<>(result);
	}
}
