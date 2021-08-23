package stack;

public interface Stack<T> {

	T peek();

	void push(T item);

	T pop();

	int search(T item);

	int size();

	boolean isEmpty();

	boolean isFull();
}
