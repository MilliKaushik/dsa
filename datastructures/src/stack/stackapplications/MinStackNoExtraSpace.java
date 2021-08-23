package stack.stackapplications;

//MIGHT CAUSE INTEGER OVERFLOW - https://leetcode.com/problems/min-stack/submissions/
//whenever you hear O(1) space, use VARIABLES
//https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=11
public class MinStackNoExtraSpace {

	private int[] stack;
	private int top;
	private int min;

	/** initialize your data structure here. */
	public MinStackNoExtraSpace() {
		top = -1;
		stack = new int[100000];
		min = -1;
	}

	public void push(int val) {
		if (isEmpty()) {
			stack[++top] = val;
			min = val;
		} else {
			if (val >= min)
				stack[++top] = val;
			else {
				int newVal = 2 * val - min;
				stack[++top] = newVal;
				min = val;
			}
		}
	}

	public void pop() {
		if (isEmpty())
			return;
		if (stack[top] >= min)
			top--;
		else if (stack[top] < min) {
			int val = min;
			min = 2 * min - stack[top--];
//			return val;
		}
	}

	public int top() {
		if (isEmpty())
			return -1;
		if (stack[top] >= min)
			return stack[top];
		else
			return min;
	}

	public int getMin() {
		if (isEmpty())
			return -1;
		return min;
	}

	private boolean isEmpty() {
		return top == -1;
	}
}
