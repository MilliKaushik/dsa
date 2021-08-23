package array.misc;

//https://www.youtube.com/watch?v=3RhGdmoF_ac
//whenever sorted array, use binary search
public class MinimumAbsoluteDifferenceInSortedArray {

	// Brute force O(n)
	public int minimumAbsoluteDifference(int[] num, int key) {
		int n = num.length;
		int min = Math.abs(num[0] - key);
		int minElement = num[0];
		for (int i = 1; i < n; i++) {
			if (Math.abs(num[i] - key) < min) {
				minElement = num[i];
				min = Math.abs(num[i] - key);
			}
		}
		return minElement;
	}

	// Use binary search - O(logn)
	// this problem can be converted to finding if key is present or if key is not
	// present, then return the min diff with the two elements near where key would
	// have been present
	public int minimumAbsoluteDiff(int[] num, int key) {
		return minAbsDiffHelper(num, 0, num.length - 1, key);
	}

	private int minAbsDiffHelper(int[] num, int st, int end, int key) {
		int mid = st + (end - st) / 2;
		while (st <= end) {
			if (num[mid] == key)
				return num[mid];
			else if (num[mid] > key)
				end = mid - 1;
			else
				st = mid + 1;
		}
		return Math.min(Math.abs(key - num[st]), Math.abs(key - num[end]));
	}
}
