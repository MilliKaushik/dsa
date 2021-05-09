package dynamicProgramming;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
public class HouseRobber {

	// TLE
	public int robRecursive(int[] nums) {
		return robRecursiveHelper(nums, 0, nums.length - 1);
	}

	private int robRecursiveHelper(int[] nums, int st, int end) {
		if (st == end)
			return nums[st];
		if (end == st + 1)
			return Math.max(nums[st], nums[end]);
		return Math.max(nums[end] + robRecursiveHelper(nums, st, end - 2), robRecursiveHelper(nums, st, end - 1));
	}

	// Accepted
	public int robMemoized(int[] nums) {
		int n = nums.length;
		int[] robValue = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			robValue[i] = -1;
		}
		return robMemoizedHelper(nums, 0, n - 1, robValue);
	}

	private int robMemoizedHelper(int[] nums, int st, int end, int[] robValue) {
		if (st == end) {
			robValue[end] = nums[st];
		} else if (end == st + 1)
			robValue[end] = Math.max(nums[st], nums[end]);
		else {
			if (robValue[end] != -1)
				return robValue[end];
			else
				robValue[end] = Math.max(nums[end] + robMemoizedHelper(nums, st, end - 2, robValue),
						robMemoizedHelper(nums, st, end - 1, robValue));
		}
		return robValue[end];
	}

	// Accepted
	public int robTabular(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);
		int[] robValue = new int[n + 1];
		robValue[0] = 0;
		robValue[1] = nums[0];
		robValue[2] = Math.max(nums[0], nums[1]);
		for (int i = 3; i <= n; i++) {
			robValue[i] = Math.max(nums[i - 1] + robValue[i - 2], robValue[i - 1]);
		}
		return robValue[n];
	}
}
