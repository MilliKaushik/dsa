package stack.stackapplications;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
public class StockSpanner {

	private class Element {
		private int element;
		private int index;
		private int nextGreaterToLeftCount;

		public Element(int element, int index, int nextGreaterToLeftCount) {
			this.element = element;
			this.index = index;
			this.nextGreaterToLeftCount = nextGreaterToLeftCount;
		}

	}

	private Stack<Element> stack;
	int index;

	public StockSpanner() {
		stack = new Stack<>();
		index = 0;
	}

	public int next(int price) {
		index++;
		int nextGreaterToLeftCount = 1;
		Element lastSmallerElement = null;
		while (!stack.isEmpty() && stack.peek().element <= price)
			lastSmallerElement = stack.pop();
		if (lastSmallerElement != null)
			nextGreaterToLeftCount = index - lastSmallerElement.index + lastSmallerElement.nextGreaterToLeftCount;
		stack.push(new Element(price, index, nextGreaterToLeftCount));
		return nextGreaterToLeftCount;
	}
}
