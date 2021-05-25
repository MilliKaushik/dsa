package stack;

public class LinkedListStack<T> implements Stack<T> {

	private class Node {
		T data;
		Node next;
	}

	Node top;

	public LinkedListStack() {
		this.top = null;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Underflow");
		return top.data;
	}

	@Override
	public void push(T item) {
		if (isFull())
			throw new RuntimeException("Overflow");
		Node node = new Node();
		node.data = item;
		node.next = top;
		top = node;
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new RuntimeException("Underflow");
		T current = top.data;
		top = top.next;
		return current;
	}

	@Override
	public int search(T item) {
		Node temp = top;
		int counter = 0;
		while (true) {
			if (temp == null)
				break;
			counter++;
			if (temp.data == item) {
				return counter;
			}
			temp = temp.next;
		}
		return -1;
	}

	@Override
	public int size() {
		int count = 0;
		Node temp = top;
		while (true) {
			if (temp == null)
				break;
			temp = temp.next;
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		Node node = new Node();
		if (node == null)
			return true;
		return false;
	}

}
