package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=3DdP6Ef8YZM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3
//https://www.interviewbit.com/problems/k-largest-elements/
public class KLargestElementsInArray {

	public ArrayList<Integer> findKLargest(ArrayList<Integer> arr, int k) {
		int n = arr.size();
		if (n < k)
			return new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (minHeap.size() > k)
				minHeap.remove();
			minHeap.add(arr.get(i));
		}
		if (minHeap.size() > k)
			minHeap.remove();
		ArrayList<Integer> kLargestElements = new ArrayList<>();
		for (int j = 0; j < k; j++)
			kLargestElements.add(minHeap.remove());
		return kLargestElements;
	}
}
