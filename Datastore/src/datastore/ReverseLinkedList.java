package datastore;

public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode node) {
		if (node == null || node.next == null)
			return node;
		ListNode rest = reverseLinkedList(node.next);
		node.next.next = node;
		node.next = null;
		return rest;
	}

	public void printList(ListNode node) {
		ListNode current = node;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println();
	}
}
