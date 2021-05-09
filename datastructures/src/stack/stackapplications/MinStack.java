package stack.stackapplications;

import java.util.Stack;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/562/
public class MinStack {

	private int[] stack;
	private int top;
	private Stack<Integer> min;

	/** initialize your data structure here. */
	public MinStack() {
		top = -1;
		stack = new int[100000];
		min = new Stack<>();
	}

	public void push(int val) {
		if (min.isEmpty() || min.peek() >= val)
			min.push(val);
		stack[++top] = val;
	}

	public void pop() {
		if (isEmpty())
			return;
		if (this.top() == min.peek())
			min.pop();
		System.out.println(stack[top--]);
	}

	public int top() {
		if (isEmpty())
			return -1;
		return stack[top];
	}

	public int getMin() {
		return min.peek();
	}

	private boolean isEmpty() {
		return top == -1;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
