package array.slidingWindow;

import java.util.ArrayList;

//SLIDING WINDOW : 1. array/strung 2. sub array 3. window of size k

// Fixed size window
// while(i < size)
// calculations
// if(i - j + 1 == k) - window size is hit, we have to do three things :
// 1. get the answer from all the calculation
// 2. slide the window(how to remove what we added for j)
//https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class MaximumSumSubarrayOfSizeK {

	public int maximumSumSubarray(int k, ArrayList<Integer> arr, int N) {
		int i = 0, j = 0;
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		// here j denotes start of window and i denotes end of window
		// condition : till end of window : i hits end of array
		while (i < arr.size()) {
			// currSum should always contain the sum of the elements in the window
			currSum += arr.get(i);
			// window size hit
			if (i - j + 1 == k) {
				// when we hit window, 1. find maximum 2. fix currSUm to exclude the element not
				// in window 3. move the window by doing j++
				maxSum = Math.max(currSum, maxSum);
				currSum -= arr.get(j);
				j++;
			}
			i++;
		}
		return maxSum;
	}
}
