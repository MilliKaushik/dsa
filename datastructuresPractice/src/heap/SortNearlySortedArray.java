package heap;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
//Not Tested
public class SortNearlySortedArray {

	public int[] sort(int[] arr, int k) {
		int n = arr.length;
		int[] result = new int[n];
		int j = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k)
				result[j++] = minHeap.remove();
		}
		while (!minHeap.isEmpty())
			result[k++] = minHeap.remove();
		return result;
	}
}
