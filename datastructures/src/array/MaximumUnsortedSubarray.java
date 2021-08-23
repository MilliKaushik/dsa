package array;

//https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class MaximumUnsortedSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int endIndex = 0;
		int startIndex = 0;
		for (startIndex = 0; startIndex < nums.length - 1; startIndex++) {
			if (nums[startIndex] > nums[startIndex + 1])
				break;
		}

		// array is sorted
		if (startIndex == nums.length - 1)
			return 0;

		for (endIndex = nums.length - 1; endIndex > 0; endIndex--) {
			if (nums[endIndex] < nums[endIndex - 1])
				break;
		}

		int max = nums[startIndex];
		int min = nums[startIndex];
		for (int j = startIndex + 1; j <= endIndex; j++) {
			if (nums[j] < min)
				min = nums[j];
			if (nums[j] > max)
				max = nums[j];
		}

		for (int i = 0; i < startIndex; i++) {
			if (nums[i] > min) {
				startIndex = i;
				break;
			}
		}

		for (int i = nums.length - 1; i > endIndex; i--) {
			if (nums[i] < max) {
				endIndex = i;
				break;
			}
		}

		return endIndex - startIndex + 1;
	}
}
