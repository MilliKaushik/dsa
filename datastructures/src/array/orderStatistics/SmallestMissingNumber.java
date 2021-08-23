package array.orderStatistics;

public class SmallestMissingNumber {
//https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
//https://www.geeksforgeeks.org/find-the-first-missing-number/
	public int smallestMissingRangeZeroToM(int[] num) {
		return findFirstMissing(num, 0, num.length - 1);
	}

	private int findFirstMissing(int[] num, int st, int end) {
		if (st > end)
			return end + 1;
		if (num[st] != st)
			return st;
		int m = (st + end) / 2;
		if (num[m] == m)
			return findFirstMissing(num, m + 1, end);
		return findFirstMissing(num, st, m);
	}

	// O(n) space solution
	// https://leetcode.com/problems/first-missing-positive/
	public int findFirstMissingPositive(int[] nums) {
		int n = nums.length;
		boolean[] found = new boolean[n];
		for (int i = 0; i < n; i++)
			found[i] = false;
		for (int i = 0; i < n; i++)
			if (nums[i] > 0 && nums[i] <= n)
				found[nums[i] - 1] = true;

		for (int i = 0; i < n; i++)
			if (!found[i])
				return i + 1;
		return n + 1;
	}

	// O(1) space solution
	// https://leetcode.com/problems/first-missing-positive/
	public int findFirstMissingPositiveConstantSpace(int[] nums) {
		int n = nums.length;
		segregatePosNeg(nums);
		int lastPositiveIndex = n - 1;
		for (int i = n - 1; i >= 0; i--)
			if (nums[i] <= 0)
				lastPositiveIndex--;
		if (lastPositiveIndex == -1)
			return 1;
		for (int i = 0; i <= lastPositiveIndex; i++) {
			if (nums[i] >= 1 && nums[i] <= n) {
				int a = nums[i];
				if (a < 0)
					a *= -1;
				if (nums[a - 1] > 0)
					nums[a - 1] *= -1;
			}
		}

		return 0;
	}

	private void segregatePosNeg(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			while (nums[i] <= 0 && i < j) {
				swap(nums, i, j);
				j--;
			}
			i++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
