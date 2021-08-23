package string;

//Can string be used to solve this?
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
public class ReverseInteger {

	public int reverse(int x) {
		boolean isNegative = x < 0 ? true : false;
		String s = String.valueOf(x);
		char[] strArr = s.toCharArray();
		int st = isNegative ? 1 : 0;
		int end = s.length() - 1;
		while (st < end) {
			swap(strArr, st, end);
			st++;
			end--;
		}
		long val = Long.parseLong(String.valueOf(strArr));
		if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE)
			return 0;
		return (int) val;
	}

	private void swap(char[] strArr, int st, int end) {
		char temp = strArr[st];
		strArr[st] = strArr[end];
		strArr[end] = temp;
	}
}
