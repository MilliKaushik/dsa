package backtracking;

import java.util.TreeSet;

//https://www.interviewbit.com/problems/next-similar-number/
public class NextSimilarNumber {

	public static String solve(String str) {
		TreeSet<String> strPermutations = new TreeSet<>();
		findPermutations(str, new StringBuilder(), str, strPermutations);
		String nextHigher = strPermutations.higher(str);
		if (nextHigher == null)
			return "-1";
		return nextHigher;
	}

	private static void findPermutations(String str, StringBuilder path, String rest, TreeSet<String> set) {
		if (str.length() == path.length()) {
			// optimization so that we only add the strings which are placed after this
			// number to the set
			if (str.compareTo(path.toString()) < 0)
			set.add(path.toString());
			return;
		}

		for (int i = 0; i < rest.length(); i++) {
			path.append(rest.charAt(i));
			String left = rest.substring(0, i);
			String right = rest.substring(i + 1, rest.length());
			findPermutations(str, path, left + right, set);
			path.deleteCharAt(path.length() - 1);
		}
	}

	public static void main(String[] args) {
		// System.out.println(solve("312"));
		System.out.println(solve("740948"));
	}
}
