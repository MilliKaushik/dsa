package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/next-greater-element-iii/
//https://www.interviewbit.com/problems/next-similar-number/
public class NextHigherNumber {

	public static int nextGreaterElement(int n) {
		List<Integer> digits = getDigits(n);
		for (int i = digits.size() - 1; i > 0; i--) {
			if (digits.get(i) > digits.get(i - 1)) {
				int minGreaterIndex = i;
				for (int j = i; j < digits.size(); j++)
					if (digits.get(i - 1) < digits.get(j) && digits.get(minGreaterIndex) > digits.get(j))
						minGreaterIndex = j;
				swap(digits, i - 1, minGreaterIndex);
				Collections.sort(digits.subList(i, digits.size()));
				return convertToNumber(digits);
			}
		}
		return -1;
	}

	private static void swap(List<Integer> digits, int i, int j) {
		int temp = digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
	}

	private static int convertToNumber(List<Integer> list) {
		long n = 0;
		int base = 10;
		int pow = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			// if (n > Integer.MAX_VALUE / 10 || (n == Integer.MAX_VALUE && list.get(i) >=
			// 2))
			// return -1;
			n += list.get(i) * Math.pow(base, pow);
			pow++;
		}
		if (n > Integer.MAX_VALUE)
			return -1;
		return (int) n;
	}

	private static List<Integer> getDigits(int n) {
		List<Integer> digits = new ArrayList<>();
		while (n > 0) {
			digits.add(n % 10);
			n /= 10;
		}
		Collections.reverse(digits);
		return digits;
	}

	// input is string
	public static String solve(String a) {
		for (int i = a.length() - 1; i > 0; i--) {
			if (a.charAt(i) > a.charAt(i - 1)) {
				int minGreaterIndex = i;
				for (int j = i; j < a.length(); j++)
					if (a.charAt(i - 1) < a.charAt(j) && a.charAt(minGreaterIndex) > a.charAt(j))
						minGreaterIndex = j;
				swap2(a, i - 1, minGreaterIndex);
				String nextHigherElement = sortString(a, i, a.length());
				if (isValidInteger(nextHigherElement))
					return nextHigherElement;
				else
					return "-1";
			}
		}
		return "-1";
	}

	private static boolean isValidInteger(String nextHigherElement) {
		Long longValue = Long.valueOf(nextHigherElement);
		return longValue < Integer.MAX_VALUE;
	}

	private static String sortString(String a, int st, int end) {
		char[] chArray = a.toCharArray();
//exclusive
		Arrays.sort(chArray, st, end);
		return a.substring(0, st - 1) + chArray.toString();
	}

	// https://stackoverflow.com/questions/6952363/replace-a-character-at-a-specific-index-in-a-string
	private static void swap2(String digits, int i, int j) {
		StringBuilder str = new StringBuilder(digits);

		char temp = digits.charAt(i);
		str.setCharAt(i, digits.charAt(j));
		str.setCharAt(j, temp);
		digits = str.toString();
	}

	public static void main(String[] args) {
		// System.out.println(nextGreaterElement(2147483486));
		System.out.println(solve("1"));
		System.out.println(solve("2"));
	}
}