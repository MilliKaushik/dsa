package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public int findKthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		if (k > arr.length)
			return -1;
		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k)
				maxHeap.remove();
		}
		return maxHeap.peek();
	}
}
