package stack.stackapplications;

import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementCircularArray {

	public int[] nextGreaterElements(int[] arr) {
		Stack<Integer> s = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--)
			s.push(arr[i]);
		int[] result = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			if (s.isEmpty())
				result[i] = -1;
			else if (s.peek() > arr[i])
				result[i] = s.peek();
			else if (s.peek() <= arr[i]) {
				while (!s.isEmpty() && s.peek() <= arr[i])
					s.pop();
				if (s.isEmpty())
					result[i] = -1;
				else
					result[i] = s.peek();
			}
			s.push(arr[i]);
		}
		return result;
	}
}