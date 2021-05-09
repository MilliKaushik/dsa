package array.search;

//https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/
public class MissingNoInArray {

	int MissingNumberXOR(int[] nums) {
		int n = nums.length;
		int xor = 0;
		for (int i = 1; i <= n; i++) {
			xor ^= nums[i - 1];
			xor ^= i;
		}
		return xor;
	}

	int MissingNumberSummation(int array[], int n) {
		int sum = 1;
		for (int i = 2; i <= n + 1; i++) {
			sum += i;
			sum -= array[i - 2];
		}
		return sum;
	}
}
