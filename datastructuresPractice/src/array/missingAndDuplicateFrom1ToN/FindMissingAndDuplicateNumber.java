package array.missingAndDuplicateFrom1ToN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.youtube.com/watch?v=G4_OxJGonQY&list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx&index=4
public class FindMissingAndDuplicateNumber {
//can also be done in one traversal with some modification
	// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
	public int[] findMissingAndDuplicateSingle(int[] arr) {
		int[] result = new int[2];
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != arr[arr[i] - 1])
				swap(arr, i, arr[i] - 1);
			else
				i++;
		}

		for (i = 0; i < arr.length; i++)
			if (arr[i] != i + 1)
				break;
		result[0] = arr[i];
		result[1] = i + 1;
		return result;
	}

	public int[][] findMissingAndDuplicateMultiple(int[] arr) {
		int[][] result = new int[arr.length][2];
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != i + 1) {
				// duplicate as that number is already in its place so just move pointer ahead
				while (arr[i] != i + 1) {
					if (arr[arr[i] - 1] == arr[i])
						break;
					swap(arr, i, arr[i] - 1);
				}
			}
			i++;
		}

		for (i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				result[i][0] = arr[i];
				result[i][1] = i + 1;
			}
		}
		return result;
	}

	private void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		int n = A.size();
		Collections.sort(A);
		int duplicate = 0;
		for (int i = 0; i < n - 1; i++) {
			if (A.get(i).equals(A.get(i + 1))) {
				duplicate = A.get(i);
			}
		}
		int sumOfNNumbers = n * (n + 1) / 2;
		int sum = 0;
		for (Integer x : A)
			sum += x;
		// sumOfNNumbers - sum = missing - duplicate
		int missing = sumOfNNumbers - sum + duplicate;
		// RHS = missing - duplicate + duplicate
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(duplicate);
		ans.add(missing);
		return ans;
	}
}
