package array.bitwise;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		for (int i = 1 << 30; i > 0; i /= 2) {
			if ((x & i) != 0)
				str1.append(1);
			else
				str1.append(0);
			if ((y & i) != 0)
				str2.append(1);
			else
				str2.append(0);
		}
		int j = 0;
		int k = 0;
		int countDiffBits = 0;
		while (j < str1.length() && k < str2.length()) {
			if (str1.charAt(j) != str2.charAt(k))
				countDiffBits++;
			j++;
			k++;
		}
		return countDiffBits;
	}
}
