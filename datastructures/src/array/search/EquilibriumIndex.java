package array.search;

//https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class EquilibriumIndex {

	public int getEquilibriumIndex(int[] num) {
		int n = num.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += num[i];

		int prefixSum = 0;
		for (int i = 0; i < n; i++) {
			int suffixSum = sum - prefixSum - num[i];
			if (prefixSum == suffixSum)
				return i;
			prefixSum += num[i];
		}
		return -1;
	}

}