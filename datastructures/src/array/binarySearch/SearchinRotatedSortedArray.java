package array.binarySearch;

//https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/804/
public class SearchinRotatedSortedArray {

	public int search(int[] nums, int target) {
		int n = nums.length;
		if (n == 1)
			return (target == nums[0] ? 0 : -1);
		int pivot = findPivot(nums);
		if (pivot == 0 || (target >= nums[pivot] && target <= nums[n - 1]))
			return binarySearch(nums, pivot, n - 1, target);
		else if (target >= nums[0] && target <= nums[pivot - 1])
			return binarySearch(nums, 0, pivot - 1, target);
		return -1;
	}

	private int binarySearch(int[] nums, int low, int high, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				return binarySearch(nums, low, mid - 1, target);
			else
				return binarySearch(nums, mid + 1, high, target);
		}
		return -1;
	}

	private int findPivot(int[] nums) {
		int n = nums.length;
		int low = 0;
		int high = n - 1;
		int prev, next;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			prev = (mid - 1 + n) % n;
			next = (mid + 1) % n;
			if (nums[mid] < nums[prev] && nums[mid] < nums[next])
				return mid;
			else if (nums[low] <= nums[mid] && nums[mid] >= nums[0])
				low = mid + 1;
			// else if (nums[mid] <= nums[high] && nums[mid] < nums[0])
			else
				high = mid - 1;
		}
		return 0;
	}
}
