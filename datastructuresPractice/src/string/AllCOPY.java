package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import linkedList.ListNode;

public class AllCOPY {

	private static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node newHead = null;
		Node current = head;
		while (current != null) {
			Node node = new Node(current.val);
			node.next = current.next;
			current.next = node;
			current = node.next;
		}
		newHead = head.next;

		current = head;
		while (current != null) {
			if (current.random != null)
				current.next.random = current.random.next;
			else
				current.next.random = null;
			current = current.next.next;
		}

		current = head;
		while (current != null) {
			Node next = current.next.next;
			if (next != null)
				current.next.next = next.next;
			else
				current.next.next = null;
			current.next = next;
			current = next;
		}
		return newHead;
	}

	public static int trap(final List<Integer> A) {
		List<Integer> maxRight = new ArrayList<>();
		List<Integer> maxLeft = new ArrayList<>();
		maxLeft.add(A.get(0));
		for (int i = 1; i < A.size(); i++)
			maxLeft.add(Math.max(maxLeft.get(i - 1), A.get(i)));

		maxRight.add(A.get(A.size() - 1));
		int index = 1;
		for (int i = A.size() - 2; i >= 0; i--) {
			maxRight.add(Math.max(maxRight.get(index - 1), A.get(i)));
			index++;
		}
		Collections.reverse(maxRight);

		int sum = 0;
		for (int i = 0; i < A.size(); i++)
			sum += Math.min(maxRight.get(i), maxLeft.get(i)) - A.get(i);
		return sum;
	}

	public int largestRectangleArea(ArrayList<Integer> A) {
		List<Integer> nsl = findNearestSmallerLeft(A);
		List<Integer> nsr = findNearestSmallerRight(A);
		int max = 0;
		for (int i = 0; i < A.size(); i++)
			max = Math.max(A.get(i) * (nsl.get(i) - nsr.get(i) - 1), max);
		return max;
	}

	private class Element {
		private Integer item;
		private Integer index;

		public Element(Integer item, Integer index) {
			super();
			this.item = item;
			this.index = index;
		}
	}

	private List<Integer> findNearestSmallerRight(ArrayList<Integer> a) {
		List<Integer> result = new ArrayList<>();
		Stack<Element> stack = new Stack<>();
		int minIndex = -1;
		stack.push(new Element(a.get(0), 0));
		result.add(minIndex);
		for (int i = 1; i < a.size(); i++) {
			if (stack.peek().item < a.get(i))
				result.add(stack.peek().index);
			else {
				while (!stack.isEmpty() && stack.peek().item >= a.get(i))
					stack.pop();
				if (stack.isEmpty())
					result.add(minIndex);
				else
					result.add(stack.peek().index);
			}
			stack.push(new Element(a.get(i), i));
		}
		return result;
	}

	private List<Integer> findNearestSmallerLeft(ArrayList<Integer> a) {
		List<Integer> result = new ArrayList<>();
		Stack<Element> stack = new Stack<>();
		int n = a.size();
		int maxIndex = n;
		stack.push(new Element(a.get(n - 1), n - 1));
		result.add(maxIndex);
		for (int i = n - 2; i >= 0; i--) {
			if (stack.peek().item < a.get(i))
				result.add(stack.peek().index);
			else {
				while (!stack.isEmpty() && stack.peek().item >= a.get(i))
					stack.pop();
				if (stack.isEmpty())
					result.add(maxIndex);
				else
					result.add(stack.peek().index);
			}
			stack.push(new Element(a.get(i), i));
		}
		Collections.reverse(result);
		return result;
	}

	private static int top = -1;
	private static int[] stack = new int[1000000];
	private static int min = -1;

	public static void push(int x) {
		int currEle = x;
		if (min == -1)
			min = x;
		else if (x < min) {
			currEle = 2 * x - min;
			min = x;
		}
		stack[++top] = currEle;
	}

	public static void pop() {
		if (isEmpty())
			return;
		if (stack[top] < min)
			min = 2 * min - stack[top];
		top--;
		if (top == -1)
			min = -1;
	}

	public static int top() {
		if (isEmpty())
			return -1;
		if (stack[top] < min)
			return min;
		else
			return stack[top];
	}

	public static int getMin() {
		return min;
	}

	private static boolean isEmpty() {
		return top == -1;
	}

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int min = -1;
		while (i < a.size()) {
			if (stack.isEmpty())
				result.add(min);
			else if (stack.peek() < a.get(i))
				result.add(stack.peek());
			else {
				while (!stack.isEmpty() && stack.peek() >= a.get(i))
					stack.pop();
				if (stack.isEmpty())
					result.add(min);
				else
					result.add(stack.peek());
			}
			stack.push(a.get(i));
			i++;
		}
		return result;
	}

	
	public static void main(String[] args) {
		push(10);
		push(9);
		System.out.println(getMin());
		push(8);
		System.out.println(getMin());
		push(7);
		System.out.println(getMin());
		push(6);
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());

		// System.out.println(trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
	}
}
