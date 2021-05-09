package array.bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/
public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allRows = new ArrayList<>();
		allRows.add(Arrays.asList(1));

		for (int i = 1; i < numRows; i++) {
			List<Integer> currRow = new ArrayList<>();
			List<Integer> prevRow = allRows.get(i - 1);
			currRow.add(1);
			int prev, curr;
			for (int j = 1; j < i; j++) {
				prev = prevRow.get(j - 1);
				curr = prevRow.get(j);
				currRow.add(prev + curr);
			}
			currRow.add(1);
			allRows.add(currRow);
		}
		return allRows;
	}
}
