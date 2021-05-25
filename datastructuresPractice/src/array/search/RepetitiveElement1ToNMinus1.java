package array.search;

import java.util.HashSet;

//https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/
public class RepetitiveElement1ToNMinus1 {

	public int getRepetitiveIndex(int[] num) {
		int n = num.length;
		for (int i = 0; i < n; i++) {
			if (num[i] < 0)
				return num[i] * -1;
			num[num[i]] *= -1;
		}
		return -1;
	}

	// Causes overflow for large arrays
	public int getRepetitiveNatural(int[] num) {
		int n = num.length;
		int expectedSum = (n - 1) * n / 2;
		int arraySum = 0;
		for (int i = 0; i < n; i++)
			arraySum += num[i];

		return arraySum - expectedSum;
	}

	public int findRepeatingHashSet(int arr[], int n) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (s.contains(arr[i]))
				return arr[i];
			s.add(arr[i]);
		}

		// If input is correct, we should
		// never reach here
		return -1;
	}

	public int findRepeatingXOR(int[] num) {
		int n = num.length;
		int xor = num[0];
		for (int i = 1; i < n; i++)
			xor ^= num[i];
		for (int i = 1; i <= n - 1; i++)
			xor ^= i;
		return xor;
	}
}
