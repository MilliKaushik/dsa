package datastructrePractice.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class Microsoft2 {
	private static final char charA = 'a';
	private static final char charB = 'b';
	private static final char charC = 'c';

	private static class charFreq implements Comparable<charFreq> {
		char ch;
		int freq;

		public charFreq(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(charFreq other) {
			return Integer.compare(this.freq, other.freq);
		}
	}

	public String solution(int freqA, int freqB, int freqC) {
		// storing chars with their frequencies in desc order
		PriorityQueue<charFreq> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(new charFreq(charA, freqA));
		pq.add(new charFreq(charB, freqB));
		pq.add(new charFreq(charC, freqC));

		StringBuilder str = new StringBuilder();

		while (!pq.isEmpty()) {
			charFreq current = pq.poll();
			// if the freq of the current top char is 0, we break out of this loop
			if (current.freq == 0)
				break;
			// append the current char once
			str.append(current.ch);
			// each time we append a char, decrement the freq of the char
			decrementFreq(current);
			// if the queue is not empty and the freq of the next top char is not zero,
			// we will append the current char once and the next top char once to
			// get the string as -> "aab"
			// else we will check if the freq of the current
			// char is not zero, and if yes, we will append it only once to reach the string
			// -> "aa" and break out of the loop as the next top char is 0 and current char
			// cannot be added anymore
			if (!pq.isEmpty() && pq.peek().freq != 0) {
				charFreq next = pq.poll();
				if (current.freq > next.freq) {
					str.append(current.ch);
					decrementFreq(current);
					str.append(next.ch);
					decrementFreq(next);
				}
				// adding to queue again as freq of the next top char is not zero
				if (next.freq > 0)
					pq.add(next);
			} else {
				if (current.freq > 0) {
					str.append(current.ch);
					decrementFreq(current);
					break;
				}
			}
			// adding to queue again as freq of the current char is not zero
			if (current.freq > 0)
				pq.add(current);
		}
		return str.toString();
	}

	private void decrementFreq(charFreq current) {
		int freq = current.freq;
		freq--;
		current.freq = freq;
	}
}