package stack.stackapplications;

import java.util.Stack;

//https://www.youtube.com/watch?v=asf9P2Rcopo&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
public class MinimumElementInStack {

	Stack<Integer> stack;
	Stack<Integer> minimumStack;

	public void push(int a) {
		stack.push(a);
		if (minimumStack.isEmpty() || minimumStack.peek() >= a)
			minimumStack.push(a);
	}

	public int pop() {
		if (stack.isEmpty())
			return -1;
		int top = stack.pop();
		if (minimumStack.peek() == top)
			minimumStack.pop();
		return top;
	}

	public int findMin(int[] arr) {
		if (stack.isEmpty())
			return -1;
		return minimumStack.peek();
	}
}
