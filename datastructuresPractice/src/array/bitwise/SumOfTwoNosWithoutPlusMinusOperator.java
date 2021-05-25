package array.bitwise;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/822/
public class SumOfTwoNosWithoutPlusMinusOperator {

	public int getSum(int a, int b) {
		int i = 0;
		int c = 0;
		int first = a;
		int second = b;
		// if negative number
		if ((1 << 31 & a) != 0)
			first = getTwosComplement(a);
		if ((1 << 31 & b) != 0)
			second = getTwosComplement(b);
		while (i < 32) {
			int oneBitPosition = 1 << i;
			int aBit = first & oneBitPosition;
			int bBit = second & oneBitPosition;
			if (aBit != 0 && bBit != 0)
				c += (Math.pow(2, i + 1));
			else if ((aBit | bBit) != 0)
				c += Math.pow(2, i);
			i++;
		}
		return c;
	}

	private int getTwosComplement(int n) {
		int i = 0;
		while (i < 32) {
			;
		}
		return 0;
	}
}