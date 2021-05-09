package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7
//https://leetcode.com/problems/sort-characters-by-frequency/submissions/
public class FrequencySort {

	private class Element implements Comparable<Element> {
		private Integer freq;
		private Character ch;

		public Element(Integer freq, Character ch) {
			this.freq = freq;
			this.ch = ch;
		}

		@Override
		public int compareTo(Element obj) {
			return this.freq.compareTo(obj.freq);
		}
	}

	public String frequencySort(String s) {
		int n = s.length();
		StringBuffer result = new StringBuffer();
		Map<Character, Integer> numToFreqMap = new HashMap<>();
		PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		char[] str = s.toCharArray();
		for (int i = 0; i < n; i++) {
			if (numToFreqMap.containsKey(str[i]))
				numToFreqMap.put(str[i], numToFreqMap.get(str[i]) + 1);
			else
				numToFreqMap.put(str[i], 1);
		}

		for (Entry<Character, Integer> curr : numToFreqMap.entrySet())
			// put frequency first so that min heap uses freq to sort
			maxHeap.add(new Element(curr.getValue(), curr.getKey()));

		int j = 0;
		while (!maxHeap.isEmpty()) {
			Element ele = maxHeap.remove();
			Character currCh = ele.ch;
			while (ele.freq-- != 0)
				result.append(currCh);
		}
		return result.toString();
	}
}
