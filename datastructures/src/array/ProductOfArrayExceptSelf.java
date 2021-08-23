package array;

//https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/827/
public class ProductOfArrayExceptSelf {

	// O(1) space
	public int[] productExceptSelfDivision(int[] num) {
		int n = num.length;
		int[] result = new int[n];
		int right = 1;
		int noOfZeroFound = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] == 0)
				noOfZeroFound++;
			else
				right *= num[i];
		}
		if (noOfZeroFound > 1)
			return result;
		int left = 1;
		for (int i = 0; i < n; i++) {
			result[i] = 0;
			if (noOfZeroFound == 0) {
				right /= num[i];
				result[i] = left * right;
				left *= num[i];
			} else if (num[i] == 0)
				result[i] = left * right;
		}
		return result;
	}

	// O(n) space
	public int[] productExceptWithoutDivision1(int[] num) {
		int n = num.length;
		int[] result = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = 1;
		for (int i = 1; i < n; i++)
			left[i] = left[i - 1] * num[i - 1];
		right[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--)
			right[i] = right[i + 1] * num[i + 1];
		for (int i = 0; i < n; i++)
			result[i] = left[i] * right[i];
		return result;
	}

	// below approach assumes that no element is 0
	// x/y is same as x * Math.pow(y, -1)
	public int[] productExceptSelfWithoutDivision2(int[] num) {
		int n = num.length;
		int[] result = new int[n];

		int temp = 1;
		for (int i = 0; i < n; i++)
			temp *= num[i];
		for (int i = 0; i < n; i++)
			result[i] = temp * (int) Math.pow(num[i], -1);
		return result;
	}

}
