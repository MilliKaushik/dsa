package backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {

	static List<List<Integer>> result = new ArrayList<>();

	public static List<List<Integer>> permute(int[] arr) {

		List<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++)
			arrList.add(arr[i]);
		findPermutations(arr.length, new ArrayList<>(), arrList);
		return result;
	}

	private static void findPermutations(int n, List<Integer> currPermutation, List<Integer> rest) {
		if (currPermutation.size() == n) {
			List<Integer> currPermuteCopy = new ArrayList<>(currPermutation);
			result.add(currPermuteCopy);
			return;
		}

		for (int i = 0; i < rest.size(); i++) {
			currPermutation.add(rest.get(i));
			List<Integer> prevList = rest.subList(0, i);
			List<Integer> afterList = rest.subList(i + 1, rest.size());
			List<Integer> newRest = new ArrayList<>(prevList);
			newRest.addAll(afterList);
			findPermutations(n, currPermutation, newRest);
			currPermutation.remove(currPermutation.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 3 }));
	}
}
