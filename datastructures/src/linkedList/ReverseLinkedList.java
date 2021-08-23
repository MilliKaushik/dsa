package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
public class ReverseLinkedList {

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}

	public ListNode reverseListRecursive(ListNode node) {
		if (node == null || node.next == null)
			return node;
		// correct head gets returned from each call
		ListNode rest = reverseListRecursive(node.next);
		// correcting links
		node.next.next = node;
		node.next = null;
		return rest;
	}

	public ListNode reverseListIterative(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next, nextNext;
		next = head.next;
		head.next = null;
		ListNode current = head;
		while (next != null) {
			nextNext = next.next;
			next.next = current;
			current = next;
			next = nextNext;
		}
		head = current;
		return head;
	}
}
