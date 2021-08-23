package stack.stackapplications;

import java.util.Stack;

//UNSOLVED
//https://leetcode.com/problems/container-with-most-water/
//https://www.interviewbit.com/problems/container-with-most-water/
public class ContainerWithMostWater {

	public int maxArea(int[] arr) {
		if (arr.length == 0 || arr.length == 1)
			return 0;
		int[] heights = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++)
			heights[i] = Math.min(arr[i], arr[i + 1]);
		return maximumAreaHistogram(heights);
	}

	private int maximumAreaHistogram(int[] heights) {
		int[] nextSmallerRightIndices = findNextSmallerRight(heights);
		int[] nextSmallerLeftIndices = findNextSmallerLeft(heights);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++)
			max = Math.max((nextSmallerLeftIndices[i] - nextSmallerRightIndices[i] - 1) * heights[i], max);
		return max;
	}

	private int[] findNextSmallerLeft(int[] heights) {
		int[] nextSmaller = new int[heights.length];
		Stack<Element> s = new Stack<>();
		int minIndex = -1;
		for (int i = 0; i <= heights.length - 1; i++) {
			if (s.isEmpty())
				nextSmaller[i] = minIndex;
			else if (s.peek().element < heights[i])
				nextSmaller[i] = s.peek().index;
			else {
				while (!s.isEmpty() && s.peek().element >= heights[i])
					s.pop();
				if (s.isEmpty())
					nextSmaller[i] = minIndex;
				else
					nextSmaller[i] = s.peek().index;
			}
			s.push(new Element(heights[i], i));
		}
		return nextSmaller;
	}

	private class Element {
		private int element;
		private int index;

		public Element(int element, int index) {
			this.element = element;
			this.index = index;
		}
	}

	private int[] findNextSmallerRight(int[] heights) {
		int[] nextSmaller = new int[heights.length];
		Stack<Element> s = new Stack<>();
		int maxIndex = heights.length;
		for (int i = heights.length - 1; i >= 0; i--) {
			if (s.isEmpty())
				nextSmaller[i] = maxIndex;
			else if (s.peek().element < heights[i])
				nextSmaller[i] = s.peek().index;
			else {
				while (!s.isEmpty() && s.peek().element >= heights[i])
					s.pop();
				if (s.isEmpty())
					nextSmaller[i] = maxIndex;
				else
					nextSmaller[i] = s.peek().index;
			}
			s.push(new Element(heights[i], i));
		}
		return nextSmaller;
	}
}
