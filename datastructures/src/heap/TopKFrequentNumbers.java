	package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
//https://leetcode.com/problems/top-k-frequent-elements/submissions/
public class TopKFrequentNumbers {

	private class Element implements Comparable<Element> {
		private Integer freq;
		private Integer number;

		public Element(Integer freq, Integer number) {
			this.freq = freq;
			this.number = number;
		}

		@Override
		public int compareTo(Element obj) {
			return this.freq.compareTo(obj.freq);
		}
	}

	public int[] findTopKFrequent(int[] arr, int k) {
		int n = arr.length;
		int[] result = new int[k];
		Map<Integer, Integer> numToFreqMap = new HashMap<>();
		PriorityQueue<Element> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (numToFreqMap.containsKey(arr[i]))
				numToFreqMap.put(arr[i], numToFreqMap.get(arr[i]) + 1);
			else
				numToFreqMap.put(arr[i], 1);
		}

		for (Entry<Integer, Integer> curr : numToFreqMap.entrySet()) {
			// put frequency first so that min heap uses freq to sort
			minHeap.add(new Element(curr.getValue(), curr.getKey()));
			if (minHeap.size() > k)
				minHeap.remove();
		}

		int j = 0;
		while (!minHeap.isEmpty())
			result[j++] = minHeap.remove().number;
		return result;
	}
}
