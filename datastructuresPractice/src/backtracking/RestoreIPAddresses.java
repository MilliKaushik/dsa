package backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/
//https://www.interviewbit.com/problems/valid-ip-addresses/
public class RestoreIPAddresses {
	private static int count = 0;

	public static List<String> restoreIpAddresses(String s) {
		List<String> ipAddrs = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12)
			return ipAddrs;

		for (int i = s.length() - 1; i > 0; i--) {
			String c = s.substring(i, s.length());
			if (isValid(c)) {
				StringBuilder str = new StringBuilder();
				str.append(c);
				str.insert(0, ".");
				count++;
				backtrack(s, ipAddrs, i, str);
				count = 0;
			}
		}
		return ipAddrs;
	}

	private static void backtrack(String s, List<String> ipAddrs, int index, StringBuilder path) {
		if (count == 3) {
			String c = s.substring(0, index);
			if (isValid(c)) {
				path.insert(0, c);
				ipAddrs.add(path.toString());
			}
			return;
		}

		for (int i = index - 1; i > 0; i--) {
			String c = s.substring(i, index);
			if (isValid(c)) {
				count++;
				if (count > 4)
					continue;
				path.insert(0, c);
				path.insert(0, ".");
				backtrack(s, ipAddrs, i, path);
				path = new StringBuilder(path.substring(path.lastIndexOf(".") - 1, path.length()));
			}
		}
	}

	private static boolean isValid(String c) {
		if (c.isEmpty())
			return false;
		System.out.println(c);
		int i = Integer.parseInt(c);
		return (i >= 0 && i <= 255);
	}

	public static void main(String[] args) {
//		System.out.println(restoreIpAddresses("1234"));
//		System.out.println(restoreIpAddresses("0000"));
		System.out.println(restoreIpAddresses("12345"));
		// System.out.println(restoreIpAddresses("25525511135"));
	}
}
