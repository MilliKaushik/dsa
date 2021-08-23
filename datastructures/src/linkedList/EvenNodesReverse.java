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
		while (node != null && node.next != null) {
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

	// Brute force
	public ListNode solve(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode current = head;
		int count = 1;
		ListNode st, prevInEven;
		st = prevInEven = null;
		while (current != null && current.next != null) {
			ListNode nextEven = current.next;
			current.next = nextEven.next;
			nextEven.next = null;
			if (prevInEven != null)
				prevInEven.next = nextEven;
			prevInEven = nextEven;
			if (st == null)
				st = nextEven;
			current = current.next;
		}
		st = reverse(st);
		current = head;
		ListNode currEven = st;
		while (current != null && currEven != null) {
			ListNode next = current.next;
			current.next = currEven;
			currEven = currEven.next;
			current.next.next = next;
			current = next;
		}
		return head;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rest = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return rest;
	}
}
