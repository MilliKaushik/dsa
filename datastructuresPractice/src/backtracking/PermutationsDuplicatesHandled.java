package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/permutations-ii/
public class PermutationsDuplicatesHandled {

	public static List<List<Integer>> permute(int[] arr) {
		StringBuilder rest = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
			rest.append(arr[i]);
		Set<String> resultSet = new HashSet<>();
		findPermutations(arr.length, new StringBuilder(), rest, resultSet);

		List<List<Integer>> result = new ArrayList<>();
		for (String numStr : resultSet) {
			char[] chArray = numStr.toCharArray();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < chArray.length; i++)
				list.add(chArray[i] - '0');
			result.add(list);
		}
		return result;
	}

	private static void findPermutations(int n, StringBuilder path, StringBuilder rest, Set<String> set) {
		if (path.length() == n) {
			set.add(path.toString());
			return;
		}

		for (int i = 0; i < rest.length(); i++) {
			path.append(rest.charAt(i));
			String left = rest.substring(0, i);
			String right = rest.substring(i + 1, rest.length());
			findPermutations(n, path, new StringBuilder(left + right), set);
			path.deleteCharAt(path.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 3 }));
	}
}
