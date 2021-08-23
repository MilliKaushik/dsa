package stack.stackapplications;

import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/
//https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
public class MaximumAreaRectangleInBinaryMatrixLEETCODE {

	public int maxArea(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int cols = matrix[0].length;

		int[][] arr = new int[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				arr[i][j] = Character.getNumericValue(matrix[i][j]);
		int[] flattenedArray = new int[cols];

		for (int j = 0; j < cols; j++)
			flattenedArray[j] = arr[0][j];

		int max = maximumAreaHistogram(flattenedArray);

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == 0)
					flattenedArray[j] = 0;
				else
					flattenedArray[j] += arr[i][j];
			}
			max = Math.max(maximumAreaHistogram(flattenedArray), max);
		}
		return max;
	}

	private class Pair {
		private int first;
		private int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	private int maximumAreaHistogram(int[] arr) {
		int n = arr.length;
		int[] left = findNearestSmallerToLeft(arr);
		int[] right = findNearestSmallerToRight(arr);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			// width * height
			max = Math.max((right[i] - left[i] - 1) * arr[i], max);
		return max;
	}

	private int[] findNearestSmallerToRight(int[] arr) {
		int n = arr.length;
		int maxIndex = n;
		Stack<Pair> stack = new Stack<>();
		int[] result = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty())
				result[i] = maxIndex;
			else if (stack.peek().first < arr[i])
				result[i] = stack.peek().second;
			else {
				while (!stack.isEmpty() && stack.peek().first >= arr[i])
					stack.pop();
				if (stack.isEmpty())
					result[i] = maxIndex;
				else
					result[i] = stack.peek().second;
			}
			stack.push(new Pair(arr[i], i));
		}
		return result;
	}

	private int[] findNearestSmallerToLeft(int[] arr) {
		int n = arr.length;
		int minIndex = -1;
		Stack<Pair> stack = new Stack<>();
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty())
				result[i] = minIndex;
			else if (stack.peek().first < arr[i])
				result[i] = stack.peek().second;
			else {
				while (!stack.isEmpty() && stack.peek().first >= arr[i])
					stack.pop();
				if (stack.isEmpty())
					result[i] = minIndex;
				else
					result[i] = stack.peek().second;
			}
			stack.push(new Pair(arr[i], i));
		}
		return result;
	}
}