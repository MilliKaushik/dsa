package array.bitwise;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/
public class NumberOf1Bits {

	public int hammingWeight(int n) {
		int countOne = 0;
		for (int i = 0; i < 32; i++) {
			if((n & 1<< i) != 0)
				countOne++;
		}
		return countOne;
	}

	// https://practice.geeksforgeeks.org/problems/binary-representation5003/1
	public String getBinaryRep(int n) {
		StringBuilder str = new StringBuilder();
		for (int i = 1 << 30; i > 0; i /= 2) {
			if ((n & i) != 0)
				str.append(1);
			else
				str.append(0);
		}
		return str.substring(1, str.length() - 1);
	}
}