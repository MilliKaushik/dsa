package string;

public class StringToIntegerATOI {

	public int myAtoi(String s) {
		int n = s.length();
		int i = 0;
		char[] ch = s.toCharArray();
		// taking care of leading whitespace - ' ' character
		while (i < n) {
			if (ch[i] != ' ')
				break;
			i++;
		}
		if (i == n)
			return 0;

		// checking if sign is present, if not considering to be '+'
		int sign = 1;
		if (ch[i] == '-' || ch[i] == '+') {
			if (ch[i] == '-')
				sign = -1;
			i++;
		}

		// https://dev.to/algobot76/leetcode-7-reverse-integer-73j Logic to handle
		// overflows
		// getting numbers
		int base = 0;
		while (i < n && ch[i] >= '0' && ch[i] <= '9') {
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && ch[i] - '0' > 7)) {
				if (sign == 1)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
			}
			base = 10 * base + ch[i++] - '0';
		}
		return base * sign;
	}
}
