package array.math;

import java.util.ArrayList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
//https://practice.geeksforgeeks.org/problems/plus-one/1/
public class PlusOne {

	public ArrayList<Integer> increment(ArrayList<Integer> arr, int N) {
		int n = arr.size() - 1;
		arr.set(n - 1, arr.get(n - 1) + 1);
		int carry = arr.get(n - 1) / 10;
		arr.set(n - 1, arr.get(n - 1) % 10);

		for (int i = n - 2; i >= 0; i--) {
			if (carry == 1) {
				arr.set(i, arr.get(i) + carry);
				carry = arr.get(i) / 10;
				arr.set(i, arr.get(i) % 10);
			}
		}
		if (carry == 1)
			arr.add(0, carry);
		return arr;
	}

	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int sum = digits[n - 1] + 1;
		digits[n - 1] = sum % 10;
		if (sum <= 9)
			return digits;
		int i;
		for (i = n - 2; i >= 0; i--) {
			sum = digits[i] + 1;
			digits[i] = sum % 10;
			if (sum <= 9)
				break;
		}
		if (i == -1 && sum > 9)
			return copyToArray(digits);
		else
			return digits;
	}

	private int[] copyToArray(int[] digits) {
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		for (int i = 1; i < digits.length; i++)
			newDigits[i] = digits[i];
		return newDigits;
	}
}
