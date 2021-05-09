package dynamicProgramming;

import java.util.List;
//check - not done
//longest common substring
public class CommonWord {

	public String longestCommonWord(List<String> list) {
		if (list.isEmpty())
			return null;
		if (list.size() == 1)
			return list.get(0);

		String common = findLongestCommon(list.get(0), list.get(1));
		for (int i = 2; i < list.size(); i++) {
			String longestCommon = findLongestCommon(common, list.get(i));
			common = longestCommon;
		}
		return common;
	}

	private String findLongestCommon(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();

		int[][] t = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++)
			for (int j = 0; j <= n2; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = 0;
			}
		}

		for (int i = n1; i >= 1; i--) {
			for (int j = n2; j >= 1; j--) {
				
			}
		}
		return null;
	}
}
