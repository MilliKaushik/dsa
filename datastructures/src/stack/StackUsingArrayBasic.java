package stack;

//https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
//https://www.geeksforgeeks.org/stack-data-structure-introduction-program/

//Pros: Easy to implement. Memory is saved as pointers are not involved. 
//Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.
public class StackUsingArrayBasic {

	private int capacity;
	private int[] stack;
	private int top;

	StackUsingArrayBasic(int capacity) {
		this.top = -1;
		this.capacity = capacity;
		stack = new int[capacity];
	}

	int search(int item) {
		StackUsingArrayBasic tempStack = new StackUsingArrayBasic(this.capacity);
		int currentPos = -1;
		boolean found = false;
		while (true) {
			if (this.isEmpty())
				break;
			Integer current = this.pop();
			tempStack.push(current);
			currentPos++;
			if (current == item) {
				found = true;
				break;
			}
		}

		while (true) {
			if (tempStack.isEmpty())
				break;
			this.push(tempStack.pop());
		}

		return found == true ? ++currentPos : -1;
	}

	void push(int item) {
		if (isFull())
			throw new RuntimeException("Overflow condition");

		stack[++top] = item;
	}

	int pop() {
		if (isEmpty())
			throw new RuntimeException("Underflow condition");

		return stack[top--];
	}

	int size() {
		return top + 1;
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == (capacity - 1);
	}

	int peek() {
		if (isEmpty())
			throw new RuntimeException("Underflow condition");

		return stack[top];
	}

}
