package array.binarySearch;

//https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
//similar to below approach :
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
//https://leetcode.com/problems/split-array-largest-sum/
public class AllocateMinimumNumberOfPages {

	public int[] allocate(int[] arr, int k) {
		int n = arr.length;
		if (n < k)
			return new int[] { -1 };
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			max = Math.max(arr[i], max);
		}

		int low = max, high = sum;
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isValid(arr, mid, k)) {
				res = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}

		int[] result = new int[2];
		return result;
	}

	private boolean isValid(int[] arr, int maxAllowedAllocation, int k) {
		int student = 1;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > maxAllowedAllocation) {
				student++;
				// explanation at 38.28 in the video
				// suppose 10 20 30 40 lets suppose mid is 50 so first we add 10 + 20 , when we
				// add 30, the sum becomes 60 which is greater than mid so we allocate it to the
				// next student and initialize sum to 30
				sum = arr[i];
			}
			if (student > k)
				return false;
		}
		return true;
	}

	// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/ --NOT
	// PASSED TWO TEST CASES
	public int shipWithinDays(int[] weights, int D) {
		int n = weights.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += weights[i];
			max = Math.max(weights[i], max);
		}
		int low = max;
		int high = sum;
		int res = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int minimumShipment = findMinimumShipment(weights, n, D, mid);
			if (minimumShipment != -1) {
				res = Math.min(minimumShipment, res);
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return res;
	}

	private int findMinimumShipment(int[] weights, int n, int D, int maxAllowedWeight) {
		int noOfDays = 1;
		int sum = 0;
		int maxWeight = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			sum += weights[i];
			if (sum == maxAllowedWeight) {
				System.out.println("Mid : " + maxAllowedWeight + " sum : " + sum + " last i : " + i);
				maxWeight = Math.max(sum, maxWeight);
			} else if (sum > maxAllowedWeight) {
				noOfDays++;
				System.out.println("Mid : " + maxAllowedWeight + " sum : " + sum + " last i : " + i);
				maxWeight = Math.max(sum - weights[i], maxWeight);
				sum = weights[i];
			}
			if (noOfDays > D)
				return -1;
		}
		return maxWeight;
	}
}
