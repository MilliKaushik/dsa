package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
public class KClosestNumbers {

	private class Element implements Comparable<Element> {
		private Integer difference;
		private Integer number;

		public Element(Integer difference, Integer number) {
			this.difference = difference;
			this.number = number;
		}

		@Override
		public int compareTo(Element obj) {
			return this.difference.compareTo(obj.difference);
		}
	}

	public List<Integer> findKClosest(int[] arr, int x, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			if (maxHeap.size() > k)
				maxHeap.remove();
			maxHeap.add(new Element(Math.abs(arr[i] - x), arr[i]));
		}
		if (maxHeap.size() > k)
			maxHeap.remove();
		while (!maxHeap.isEmpty())
			result.add(maxHeap.remove().number);
		return result;
	}
}
