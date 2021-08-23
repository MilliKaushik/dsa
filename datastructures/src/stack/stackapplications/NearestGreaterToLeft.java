package stack.stackapplications;

import java.util.Stack;

public class NearestGreaterToLeft {

	public int[] nearestGreaterToLeft(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty())
				result[i] = -1;
			else if (arr[i] < stack.peek())
				result[i] = stack.peek();
			else {
				while (!stack.isEmpty() && arr[i] >= stack.peek())
					stack.pop();
				if (stack.isEmpty())
					result[i] = -1;
				else if (arr[i] < stack.peek())
					result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}
}
