package heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=XC4EotTewro&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8
//https://leetcode.com/problems/k-closest-points-to-origin/submissions/
public class KClosestPointsToOrigin {

	private class Element implements Comparable<Element> {
		private Integer distance;
		private Integer x;
		private Integer y;

		public Element(Integer distance, Integer x, Integer y) {
			this.distance = distance;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Element obj) {
			return this.distance.compareTo(obj.distance);
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		int[][] result = new int[k][2];
		PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int distanceSquared = 0;
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			// x sq + y sq
			distanceSquared = x * x + y * y;
			maxHeap.add(new Element(distanceSquared, x, y));
			if (maxHeap.size() > k)
				maxHeap.remove();
		}
		int j = 0;
		while (!maxHeap.isEmpty()) {
			Element curr = maxHeap.remove();
			result[j][0] = curr.x;
			result[j][1] = curr.y;
			j++;
		}
		return result;
	}
}
