package array.misc;

//https://www.geeksforgeeks.org/minimum-increment-k-operations-make-elements-equal/
public class MinimumIncrementByKOps {

	public int minimumIncrement(int[] num, int k) {
		int n = num.length;
		int max = num[0];
		for (int i = 0; i < n; i++)
			max = Math.max(num[i], max);
		int noOfOps = 0;
		for (int i = 0; i < n; i++) {
			int j = max - num[i];
			if (j % k != 0)
				return -1;
			noOfOps += j / k;
		}
		return noOfOps;
	}
}
