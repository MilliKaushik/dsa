package array.misc;

//https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
public class TwoStacksInArray {

	int[] stack;
	int top1;
	int top2;
	int capacity;

	public TwoStacksInArray(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		top1 = -1;
		top2 = capacity;
	}

	public void push1(int x) {
		if (top1 == top2 - 1)
			throw new RuntimeException("Stack 1 overflow");
		stack[++top1] = x;
	}

	public void push2(int x) {
		if (top2 == top1 + 1)
			throw new RuntimeException("Stack 2 overflow");
		stack[--top2] = x;
	}

	public int pop1() {
		if (top1 == -1)
			throw new RuntimeException("Stack 1 underflow");
		return stack[top1--];
	}

	public int pop2() {
		if (top2 == capacity)
			throw new RuntimeException("Stack 2 underflow");
		return stack[top2++];
	}
}
