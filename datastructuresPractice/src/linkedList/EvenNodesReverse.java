package linkedList;

import java.util.Stack;

public class EvenNodesReverse {

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

//Time  : O(n) Space O(n) 2 passes through the list
	// https://www.interviewbit.com/problems/even-reverse/
	public Node evenReverse(Node head) {
		if (head == null || head.next == null)
			return head;
		Stack<Node> evenNodes = new Stack<>();
		Node node = head;
		while (node != null) {
			if (node.next == null)
				break;

			Node evenNode = node.next;
			Node nextNext = evenNode.next;
			evenNode.next = null;
			evenNodes.add(evenNode);
			node.next = nextNext;
			node = node.next;
		}

		Node current = head;
		while (!evenNodes.isEmpty()) {
			Node currentEvenNode = evenNodes.pop();
			Node next = current.next;
			current.next = currentEvenNode;
			currentEvenNode.next = next;
			current = next;
		}
		return head;
	}
}
