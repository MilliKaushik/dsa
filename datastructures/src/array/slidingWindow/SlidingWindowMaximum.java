package array.slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
//https://leetcode.com/problems/sliding-window-maximum/
//https://www.interviewbit.com/problems/sliding-window-maximum/

//Linked structures are possibly the worst structure to iterate with a cache miss on each element. On top of it they consume way
//more memory. If you need add/remove of the both ends, ArrayDeque is significantly better than a linked list. Random access each 
//element is also O(1) for a cyclic queue. The only better operation of a linked list is removing the current element during 
//iteration.

public class SlidingWindowMaximum {

	private class Pair implements Comparable<Pair> {
		Integer element;
		Integer index;

		private Pair(int element, int index) {
			this.element = element;
			this.index = index;
		}

		@Override
		public int compareTo(Pair other) {
			return this.element.compareTo(other.element);
		}
	}

	public int[] maxSlidingWindowHeap(int[] arr, int k) {
		int n = arr.length;
		int[] result = new int[n - k + 1];
		int i = 0, j = 0, a = 0;
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		while (i < n) {
			maxHeap.add(new Pair(arr[i], i));
			if (i - j + 1 == k) {
				while (!maxHeap.isEmpty() && maxHeap.peek().index < j)
					maxHeap.remove();
				result[a++] = arr[maxHeap.peek().element];
				j++;
			}
			i++;
		}
		return result;
	}

	// better solution
	public int[] maxSlidingWindowQueue(int[] arr, int k) {
		int n = arr.length;
		int[] result = new int[n - k + 1];
		int i = 0, j = 0, a = 0;
		Deque<Integer> queue = new LinkedList<>();
		while (i < n) {
			// any smaller element than this will not be used so we can pop safely
			while (!queue.isEmpty() && queue.peekLast() < arr[i])
				queue.pollLast();
			queue.add(arr[i]);
			// get answer from calculation
			if (i - j + 1 == k) {
				result[a++] = queue.peek();
				// checking if the element to be removed from the window was part of calculation
				// or not
				if (arr[j] == queue.peekFirst())
					queue.pollFirst();
				j++;
			}
			i++;
		}
		return result;
	}

	// below also handles duplicates
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int k) {
		Deque<Pair> queue = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while (i < a.size()) {
			while (!queue.isEmpty() && queue.getLast().element < a.get(i))
				queue.removeLast();

			queue.addLast(new Pair(a.get(i), i));
			if (i - j + 1 == k) {
				// whatever extra elements - out of the window - is in the front of the queue
				// will be removed before getting the answer
				while (queue.getFirst().index < j)
					queue.removeFirst();
				result.add(queue.getFirst().element);
				j++;
			}
			i++;
		}
		return result;
	}
}
