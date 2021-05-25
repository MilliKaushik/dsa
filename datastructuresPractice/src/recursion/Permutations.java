package recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {

	static public List<List<Integer>> permute(int[] arr) {
		return permuteHelper(arr, arr.length);
	}

	static public List<List<Integer>> permuteHelper(int[] arr, int n) {
		if (n == 1) {
			List<List<Integer>> d = new ArrayList<>();
			d.add(new ArrayList<>(arr[0]));
			return d;
		}
		List<List<Integer>> result = permuteHelper(arr, n - 1);
		List<List<Integer>> resultCopy = result;
		appendAtFirst(result, arr[n - 1], result.size() - 1);
		appendAtLast(resultCopy, arr[n - 1], result.size() - 1);
		result.addAll(resultCopy);
		return result;
	}

	static private void appendAtLast(List<List<Integer>> resultCopy, int element, int listPos) {
		if (listPos == -1)
			return;
		List<Integer> a = resultCopy.get(listPos);
		a.add(element);
		listPos--;
		appendAtFirst(resultCopy, element, listPos);
	}

	static private void appendAtFirst(List<List<Integer>> resultCopy, int element, int listPos) {
		if (listPos == -1)
			return;
		List<Integer> a = resultCopy.get(listPos);
		a.add(0, element);
		listPos--;
		appendAtFirst(resultCopy, element, listPos);
	}

	public static void main(String[] args) {
		permute(new int[] { 1, 2, 3 });
	}
}
