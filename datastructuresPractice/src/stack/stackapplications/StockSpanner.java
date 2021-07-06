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

	class StockSpanner1 {
		private class Element {
			private int element;
			private int span;

			public Element(int element, int span) {
				this.element = element;
				this.span = span;
			}
		}

		private Stack<Element> s;

		public StockSpanner1() {
			s = new Stack<>();
		}

		public int next(int price) {
			if (s.isEmpty() || s.peek().element > price) {
				s.push(new Element(price, 1));
				return 1;
			} else if (s.peek().element <= price) {
				int currSpan = 1;
				while (!s.isEmpty() && s.peek().element <= price)
					currSpan += s.pop().span;
				s.push(new Element(price, currSpan));
				return currSpan;
			}
			return 1;
		}
	}

	/**
	 * Your StockSpanner object will be instantiated and called as such:
	 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
	 */
}
