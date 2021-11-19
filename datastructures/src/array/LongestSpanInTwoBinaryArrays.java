package array;

//https://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
public class LongestSpanInTwoBinaryArrays {

	public int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
		int[] sum1 = new int[n];
		int[] sum2 = new int[n];
		sum1[0] = arr1[0] == true ? 1 : 0;
		sum2[0] = arr2[0] == true ? 1 : 0;
		for (int i = 1; i < n; i++)
			sum1[i] = (arr1[i] == true ? 1 : 0) + sum1[i - 1];
		for (int i = 1; i < n; i++)
			sum2[i] = (arr2[i] == true ? 1 : 0) + sum2[i - 1];
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((sum2[j] - sum2[i]) == (sum1[j] - sum1[i]))
					maxLen = Math.max(j - i, maxLen);
			}
		}
		return maxLen;
	}
}
