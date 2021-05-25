package array.search;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
public class TripletSum {

	public boolean hasTripletSum(int[] num, int sum) {
		int n = num.length;
		Arrays.sort(num);

		for (int i = 0; i < n; i++) {
			int sumToGet = sum - num[i];
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (num[j] + num[k] == sumToGet)
					return true;
				else if (num[j] + num[k] < sumToGet)
					j++;
				else
					k--;
			}
		}
		return false;
	}
}
