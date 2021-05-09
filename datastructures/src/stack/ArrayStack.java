package stack;

public class ArrayStack<T> implements Stack<T> {

	private final static int DEFAULT_SIZE = 10;
	private T container[];
	private int top;
	private int capacity;

	public ArrayStack() {
		this(DEFAULT_SIZE);
	}

	public ArrayStack(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.container = (T[]) new Object[capacity];
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Underflow");
		return container[top + 1];
	}

	@Override
	public void push(T item) {
		if (isFull())
			throw new RuntimeException("Overflow");
		container[++top] = item;
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Underflow");
		return container[top--];
	}

	@Override
	public int search(T item) {
		ArrayStack<T> tempStack = new ArrayStack<>();
		boolean found = false;
		int counter = 1;
		while (true) {
			if (this.isEmpty())
				break;
			T current = this.pop();
			tempStack.push(current);
			if (current == item) {
				found = true;
				break;
			}
			counter++;
		}
		while (true) {
			if (tempStack.isEmpty())
				break;
			T current = tempStack.pop();
			this.push(current);
		}
		if (found == true)
			return counter;
		return -1;
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == capacity - 1;
	}

}
