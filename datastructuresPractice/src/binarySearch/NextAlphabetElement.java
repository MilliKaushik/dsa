package binarySearch;

public class NextAlphabetElement {

	public char findNextAlphabet(String s, char k) {
		char[] charArray = s.toCharArray();
		int n = s.length();
		int low = 0, high = n - 1;
		char res = '#';
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (charArray[mid] > k) {
				res = charArray[mid];
				high = mid - 1;
			} else if (charArray[mid] <= k)
				low = mid + 1;
		}
		return res;
	}
}
