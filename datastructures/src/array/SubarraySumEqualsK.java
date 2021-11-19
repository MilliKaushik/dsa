package array;

import java.util.HashMap;
import java.util.Map;

//there are negative numbers as well so disregard using sliding window
//https://leetcode.com/problems/subarray-sum-equals-k/solution/ 
public class SubarraySumEqualsK {

	// Given an array of integers arr and an integer k, return the total number of
	// continuous sub arrays whose sum equals to k.
	public int subarraySum(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Integer> sumToIndex = new HashMap<>();
		sumToIndex.put(arr[0], 0);
		int prevSum = arr[0];
		for (int i = 0; i < n; i++)
            ;
			return 0;
	}
}
