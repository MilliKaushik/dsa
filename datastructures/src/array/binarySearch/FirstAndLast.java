package array.binarySearch;

public class FirstAndLast {

	public int[] searchRange(int[] nums, int target) {
		int first = findFirst(nums, target);
		int last = findLast(nums, target);
		int[] result = new int[2];
		result[0] = first;
		result[1] = last;
		return result;
	}

	private int findLast(int[] nums, int target) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				result = mid;
				low = mid + 1;
			} else if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return result;
	}

	private int findFirst(int[] nums, int target) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				result = mid;
				high = mid - 1;
			} else if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return result;
	}
}
