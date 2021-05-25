package stack.stackapplications;

import java.util.Stack;

//stock span problem = consecutive smaller or equal = NGL index = i - NGL index
//https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
public class StockSpanProblem {

	private class Element {
		private int element;
		private int index;

		public Element(int element, int index) {
			super();
			this.element = element;
			this.index = index;
		}
	}

	public int[] stockSpanProblem(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		int[] stockSpan = new int[n];
		Stack<Element> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty())
				result[i] = -1;
			else if (stack.peek().element > arr[i])
				result[i] = stack.peek().index;
			else {
				while (!stack.isEmpty() && stack.peek().element <= arr[i])
					stack.pop();
				if (stack.isEmpty())
					result[i] = -1;
				else if (stack.peek().element > arr[i])
					result[i] = stack.peek().index;
			}
			stack.push(new Element(arr[i], i));
		}

		for (int i = 0; i < n; i++)
			stockSpan[i] = i - result[i];
		return stockSpan;
	}
}
