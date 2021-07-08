package backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

//https://www.interviewbit.com/problems/kth-permutation-sequence/
public class KPermutationSequence {

	public static void main(String[] args) {
		// System.out.println(getPermutation(3, 3));
		// System.out.println(getPermutation(9, 22));
		System.out.println(getPermutation(9, 19));
	}

	static SortedSet<String> result = new TreeSet<>();

	public static String getPermutation(int n, int k) {
		List<String> list = new ArrayList<>();
		int len = 0;
		for (int i = 1; i <= n; i++) {
			list.add(String.valueOf(i));
			len += list.get(i - 1).length();
		}

		backtrack(list, new StringBuilder(), len, k);
		return result.last();
	}

	private static void backtrack(List<String> list, StringBuilder path, int len, int k) {
		if (path.length() == len) {
			result.add(path.toString());
			return;
		}

		// stop when we get kth permutation
		if (k == result.size())
			return;

		for (int i = 0; i < list.size(); i++) {
			path.append(list.get(i));
			List<String> before = list.subList(0, i);
			List<String> after = list.subList(i + 1, list.size());
			List<String> rest = new ArrayList<>(before);
			rest.addAll(after);
			backtrack(rest, path, len, k);
			path.deleteCharAt(path.length() - 1);
		}
	}
}