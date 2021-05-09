package array.binarySearch;

//Implementtation of the concept - find the first occurrence of a value in a sorted array
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/
public class FirstBadVersion {

	public int firstBadVersion(int n) {
		int low = 1;
		int high = n;
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) {
				result = mid;
				high = mid - 1;
			} else if (!isBadVersion(mid))
				low = mid + 1;
		}
		return result;
	}

	private boolean isBadVersion(int n) {
		// TODO Auto-generated method stub
		return false;
	}
}
