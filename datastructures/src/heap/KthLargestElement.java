package heap;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2
//https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
//https://www.geeksforgeeks.org/min-heap-in-java/
public class KthLargestElement {

	public int findKthLargest(int[] arr, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int n = arr.length;
		if (k > n)
			return -1;
		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k)
				minHeap.remove();
		}
		return minHeap.peek();
	}
}
