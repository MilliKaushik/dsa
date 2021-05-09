package array.bitwise;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/648/
//Java supports only signed values so this isn't possible
public class ReverseBits {

	public int reverseBits(long n) {
		Integer result = 0;
		for (int i = 0; i < 32; i++)
			if ((n & 1 << i) != 0)
				result += (int)Math.pow(2, 31 - i);
		return result;
	}
}
