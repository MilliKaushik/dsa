package stack.stackapplications;

import java.util.Stack;

//https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
public class NearestSmallerToLeft {

	public int[] nearestSmallerToLeft(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty())
				result[i] = -1;
			else if (arr[i] > stack.peek())
				result[i] = stack.peek();
			else {
				while (!stack.isEmpty() && arr[i] <= stack.peek())
					stack.pop();
				if (stack.isEmpty())
					result[i] = -1;
				else if (arr[i] > stack.peek())
					result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}
}
