package array.search;

//https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
public class PeakElement {
	public int findPeak(int[] num) {
		int n = num.length;

		if (n == 1 || num[0] >= num[1])
			return 0;
		if (num[n - 1] >= num[n - 2])
			return n - 1;
		for (int i = 1; i < n - 1; i++)
			if (num[i - 1] <= num[i] && num[i + 1] <= num[i])
				return i;

		return 0;
	}
}
