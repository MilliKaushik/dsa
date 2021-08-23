package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

//https://www.interviewbit.com/problems/maximum-sum-combinations/
public class MaximumSumCombinations {

	private static class Pair {
		private int index1;
		private int index2;

		public Pair(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index1;
			result = prime * result + index2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (index1 != other.index1)
				return false;
			if (index2 != other.index2)
				return false;
			return true;
		}
	}

	private static class Element implements Comparable<Element> {
		private int sum;
		private Pair indexes;

		public Element(int sum, Pair indexes) {
			this.sum = sum;
			this.indexes = indexes;
		}

		@Override
		public int compareTo(Element other) {
			return Integer.compare(this.sum, other.sum);
		}
	}

	// IMPLEMENT EQUALS IN PAIR BEFIRE CHECKING IF THE SET CONATINS IT
	public static ArrayList<Integer> solve1(List<Integer> a, List<Integer> b, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(a);
		Collections.sort(b);
		Set<Pair> indexes = new HashSet<>();
		PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int i = a.size() - 1;
		int j = b.size() - 1;
		maxHeap.add(new Element(a.get(i) + b.get(j), new Pair(i, j)));
		indexes.add(new Pair(i, j));

		while (k-- != 0) {
			Element top = maxHeap.poll();
			result.add(top.sum);
			i = top.indexes.index1;
			j = top.indexes.index2;

			Pair pair1 = new Pair(i - 1, j);
			if (i > 0 && !indexes.contains(pair1)) {
				maxHeap.add(new Element(a.get(i - 1) + b.get(j), pair1));
				indexes.add(pair1);
			}
			Pair pair2 = new Pair(i, j - 1);
			if (j > 0 && !indexes.contains(pair2)) {
				maxHeap.add(new Element(a.get(i) + b.get(j - 1), pair2));
				indexes.add(pair2);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> a1 = Arrays.asList(3, 2);
		List<Integer> a2 = Arrays.asList(1, 4);
		int k1 = 2;

		// System.out.println(solve1(a1, a2, k1));

		List<Integer> a11 = Arrays.asList(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83);
		List<Integer> a12 = Arrays.asList(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83);
		int k2 = 10;

		System.out.println(solve1(a11, a12, k2));

	}

	// TLE
//O(n2) worst case + O(klogk) for heap sorting
	public ArrayList<Integer> solve2(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				int sum = a.get(i) + b.get(j);
				minHeap.add(sum);
				if (minHeap.size() > k)
					minHeap.remove();
			}
		}
		while (!minHeap.isEmpty())
			result.add(minHeap.poll());
		Collections.reverse(result);
		return result;
	}
}
