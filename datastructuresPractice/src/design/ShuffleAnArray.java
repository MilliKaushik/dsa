package design;

import java.util.Random;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
public class ShuffleAnArray {

	private int[] nums;

	Random random = new Random();

	public ShuffleAnArray(int[] nums) {
		this.nums = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			this.nums[i] = nums[i];
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int n = nums.length;
		int[] shuffledArr = new int[n];
		for (int i = 0; i < n; i++)
			shuffledArr[i] = nums[i];
		for (int i = n - 1; i > 0; i--) {
			// java.util.Random.nextInt(int n) : The nextInt(int n) is used to get a random
			// number
			// between 0(inclusive) and the number passed in this argument(n), exclusive.
			int j = random.nextInt(i + 1);
			swap(shuffledArr, i, j);
		}
		return shuffledArr;
	}

	private void swap(int[] arr, int i, int randomIndex) {
		int temp = arr[i];
		arr[i] = arr[randomIndex];
		arr[randomIndex] = temp;
	}
}
