package stack.stackapplications;

import java.util.Stack;

//https://www.youtube.com/watch?v=asf9P2Rcopo&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/562/
public class MinStackExtraSpace {

	private int[] stack;
	private int top;
	private Stack<Integer> min;

	/** initialize your data structure here. */
	public MinStackExtraSpace() {
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
		if (min.isEmpty())
			return -1;
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
