package array;

public class ArrayPractice<E> {
	private static final int BASE_SIZE = 4;

	private Object[] array;
	private int length;
	private int capacity;

	public ArrayPractice() {
		this(BASE_SIZE);
	}

	public ArrayPractice(int capacity) {
		this.capacity = capacity;
		array = (E[]) new Object[capacity];
		this.length = 0;
	}

	public void print() {
		for (int i = 0; i < length; i++)
			System.out.print("array[" + i + "] : " + array[i] + " ");
		System.out.println();
	}

	public void add(E val) {
		if (length == capacity)
			increaseCapacity();
		array[length] = val;
		length++;
	//	System.out.println("Capacity after adding " + val + " is : " + capacity);
	}

	private void increaseCapacity() {
		Object[] newArray = (E[]) new Object[capacity * 2];
		for (int i = 0; i < capacity; i++)
			newArray[i] = array[i];
		array = newArray;
		capacity = capacity * 2;
	}

	public void remove(int index) {
		if (index < 0 || index >= length)
			throw new IllegalArgumentException();
		for (int i = index; i < length - 1; i++)
			array[i] = array[i + 1];
		length--;
		if (length <= capacity / 2)
			reduceCapacity();
		System.out.println("Length after removing " + index + " is : " + length);
		System.out.println("Capacity after removing " + index + " is : " + capacity);
	}

	public void remove(E val) {
		int i = 0;
		for (; i < length; i++)
			if (array[i].equals(val))
				break;
		if (i == length)
			throw new IllegalArgumentException();
		for (int j = i; j < length - 1; j++)
			array[j] = array[j + 1];
		length--;
		if (length <= capacity / 2)
			reduceCapacity();
		System.out.println("Length after removing " + val + " is : " + length);
		System.out.println("Capacity after removing " + val + " is : " + capacity);
	}

	private void reduceCapacity() {
		Object[] newArray = (E[]) new Object[capacity / 2];
		for (int i = 0; i < length; i++)
			newArray[i] = array[i];
		array = newArray;
		capacity = capacity / 2;
	}

	public int size() {
		return length;
	}
}
