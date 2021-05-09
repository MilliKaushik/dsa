package heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1#
//https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
public class KClosestNumbersGFG {

	private class Element implements Comparable<Element> {
		private Integer difference;
		private Integer number;

		public Element(Integer difference, Integer number) {
			this.difference = difference;
			this.number = number;
		}

		@Override
		public int compareTo(Element obj) {
			int retValue = this.difference.compareTo(obj.difference);
			if (retValue != 0)
				return retValue;
			return obj.number.compareTo(this.number);
		}
	}

	public int[] findKClosest(int[] arr, int x, int k) {
		int[] result = new int[k];
		PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				continue;
			if (maxHeap.size() > k)
				maxHeap.remove();
			maxHeap.add(new Element(Math.abs(arr[i] - x), arr[i]));
		}
		if (maxHeap.size() > k)
			maxHeap.remove();
		int j = 0;
		PriorityQueue<Element> minHeap = new PriorityQueue<>();
		while (!maxHeap.isEmpty())
			minHeap.add(maxHeap.remove());
		while (!minHeap.isEmpty())
			result[j++] = minHeap.remove().number;
		return result;
	}
}
