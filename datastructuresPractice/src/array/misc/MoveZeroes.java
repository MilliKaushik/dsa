package array.misc;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int lastSwapped = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				swap(nums, i, ++lastSwapped);
		}
		while (lastSwapped < nums.length - 1)
			nums[lastSwapped++] = 0;
	}

	private void swap(int[] nums, int i, int index) {
		int temp = nums[i];
		nums[i] = nums[index];
		nums[index] = temp;
	}
}
