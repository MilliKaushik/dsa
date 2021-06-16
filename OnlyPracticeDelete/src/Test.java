import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public List<List<Integer>> threeSum(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int currSum = nums[i] + nums[j];
				if (set.contains(target - currSum))
					result.add(Arrays.asList(target - currSum, nums[i], nums[j]));
			}
			set.add(nums[i]);
		}
		return result;
	}

	public int longestConsecutive(int[] arr) {
		if (arr.length == 0 || arr.length == 1)
			return arr.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		int maxLen = 1;
		int len = 1;
		for (Integer x : set) {
			if (!set.contains(x - 1)) {
				while (set.contains(x + 1)) {
					len++;
					x++;
				}
				maxLen = Math.max(maxLen, len);
			}
		}
		return maxLen;
	}

	public int findUnsortedSubarray(int[] arr) {
		int n = arr.length;
		int i = 0;
		int smallestAnamolous = -1;
		for (; i < n - 1; i++) {
			if (arr[i + 1] < arr[i] && arr[i + 1] < arr[smallestAnamolous])
				smallestAnamolous = i + 1;
		}
		if (i == n - 1)
			return 0;
		int nextGreaterLeft = findPosition(arr, 0, i, arr[smallestAnamolous]);
		int leftIndex = nextGreaterLeft == -1 ? 0 : nextGreaterLeft;

		int largestAnamoulous = -1;
		for (i = n - 1; i > 0; i--)
			if (arr[i - 1] > arr[i])
				break;
		int nextGreaterRight = findPosition(arr, i, n - 1, arr[i - 1]);
		int rightIndex = nextGreaterRight == -1 ? n - 1 : nextGreaterRight;
		return rightIndex - leftIndex + 1;
	}

	private int findPosition(int[] arr, int low, int high, int x) {
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > x) {
				result = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return result;
	}
}
