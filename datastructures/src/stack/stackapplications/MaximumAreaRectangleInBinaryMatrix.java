package stack.stackapplications;

import java.util.Stack;

//https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
public class MaximumAreaRectangleInBinaryMatrix {

	public int maxArea(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int[] flattenedArray = new int[cols];

		for (int j = 0; j < cols; j++)
			flattenedArray[j] = arr[0][j];

		int max = maximumAreaHistorgram(flattenedArray);

		for (int i = 1; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == 0)
					flattenedArray[j] = 0;
				else
					flattenedArray[j] += arr[i][j];
			}
		max = Math.max(maximumAreaHistorgram(flattenedArray), max);

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

	private int maximumAreaHistorgram(int[] arr) {
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