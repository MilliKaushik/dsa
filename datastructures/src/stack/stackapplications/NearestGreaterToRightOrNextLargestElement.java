package stack.stackapplications;

import java.util.Stack;

//https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NearestGreaterToRightOrNextLargestElement {

	public int[] nextLargestElement(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
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
