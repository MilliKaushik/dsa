package array;

public class Array<E> {
	// add an element
	// remove an element
	// index of
	// print

	private Object[] arr;
	private int count;
	private int length;

	public Array(int length) {
		arr = (E[]) new Object[length];
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(arr[i]);
		}
	}

	public void add(E item) {
		if (count == arr.length) {
			E[] newArr = (E[]) new Object[2 * count];
			for (int i = 0; i < count; i++)
				newArr[i] = (E) arr[i];
			arr = newArr;
		}
		arr[count++] = item;
	}

	public void removeAt(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException("Incorrect index passed");
		for (int i = index; i < count; i++)
			arr[i] = arr[i + 1];

		count--;
	}

	public int indexOf(E item) {
		for (int i = 0; i < count; i++)
			if ((E) arr[i] == item)
				return i;

		return -1;
	}

}
