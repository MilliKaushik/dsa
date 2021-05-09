package array.slidingWindow;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class MaximumSumSubarrayOfSizeK {

	static int maximumSumSubarray(int k, ArrayList<Integer> arr, int N) {
		int i = 0;
		int j = 0;
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;

		while (j < arr.size()) {
			currSum += arr.get(j);
			if (j - i + 1 == k) {
				maxSum = Math.max(currSum, maxSum);
				currSum -= arr.get(i);
				i++;
			}
			j++;
		}
		return maxSum;
	}
}
