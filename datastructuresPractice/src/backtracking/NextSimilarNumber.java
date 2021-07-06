package backtracking;

import java.util.TreeSet;

//https://www.interviewbit.com/problems/next-similar-number/
public class NextSimilarNumber {

	public static String solve(String str) {
		TreeSet<String> strPermutations = findPermutations(str);
		return strPermutations.higher(str);
	}

	private static TreeSet<String> findPermutations(String str) {
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < str.length(); i++) {
			StringBuilder path = new StringBuilder();
			path.append(str.charAt(i));
			backtrack(str, set, i, i, path);
		}
		return set;
	}

	private static void backtrack(String str, TreeSet<String> set, int index, int currentIndex, StringBuilder path) {
		if (str.length() == path.length()) {
			if (str.compareTo(path.toString()) == -1)
				set.add(path.toString());
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			if (i != index && i != currentIndex) {
				path.append(str.charAt(i));
				backtrack(str, set, index, i + 1, path);
				path.deleteCharAt(path.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solve("132"));
	}
}
