package array.slidingWindow;

//unchecked
//https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=8F
public class LargestSubarrayEqualToKVariableSW {

	public static int lenOfLongSubarr(int arr[], int N, int k) {
		int n = arr.length;
		int maxLen = 0, i = 0, j = 0, sum = 0;
		while (i < n) {
			sum += arr[i];
			if (sum > k) {
				while (sum > k)
					sum -= arr[j++];
			}
			if (sum == k)
				maxLen = Math.max(i - j + 1, maxLen);
			i++;
		}
		return maxLen;
	}
}
