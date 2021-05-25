package array.orderStatistics;

import java.util.Arrays;

//https://www.youtube.com/watch?v=t0Cq6tVNRBA
//https://www.youtube.com/watch?v=HqPJF2L5h9U
public class MinHeap {
	private int capacity = 10;
	private int size = 0;
	private int[] heap;

	public MinHeap(int size) {
		heap = new int[size];
		this.size = size;
	}

	public int peek() {
		if (size == 0)
			throw new IllegalArgumentException();
		return heap[0];
	}

	public int extractMin() {
		if (size == 0)
			throw new IllegalArgumentException();
		int min = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapifyDown();
		return min;
	}

	public void add(int item) {
		ensureCapacity();
		heap[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > heap[index]) {
			swap(getParentIndex(index), heap[index]);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index))
				smallerChildIndex = getRightChildIndex(index);
			if (heap[index] < heap[smallerChildIndex])
				break;
			else
				swap(heap[index], heap[smallerChildIndex]);
			index = smallerChildIndex;
		}
	}

	private int parent(int index) {
		return heap[getParentIndex(index)];
	}

	private int getParentIndex(int index) {
		return 0;
	}

	private int leftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}

	private int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	private int rightChild(int index) {
		return heap[getRightChildIndex(index)];
	}

	private int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private void ensureCapacity() {
		if (size == capacity)
			heap = Arrays.copyOf(heap, 2 * capacity * 2);
		capacity *= 2;
	}

	private void swap(int first, int second) {
		int temp = first;
		second = first;
		first = temp;
	}

}
