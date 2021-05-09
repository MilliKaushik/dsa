package array.misc;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/
public class GenerateSubarraySubsequence {

	public List<List<Integer>> generateSubArray(int[] num) {
		List<List<Integer>> subArrays = new ArrayList<>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				List<Integer> currentSubArray = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					currentSubArray.add(num[k]);
				}
				subArrays.add(currentSubArray);
			}
		}
		return subArrays;
	}

	public List<List<Integer>> generateSubSequence(int[] num) {
		List<List<Integer>> subSequences = new ArrayList<>();

		return subSequences;
	}
}
