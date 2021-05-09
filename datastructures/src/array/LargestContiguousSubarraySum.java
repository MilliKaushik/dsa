package array;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestContiguousSubarraySum {

	public void findLargestContiguousSubarraySum(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		int start = 0, end = 0;
		int s = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = s;
				end = i;
			}

			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				s = i + 1;
			}
		}
	}
}
