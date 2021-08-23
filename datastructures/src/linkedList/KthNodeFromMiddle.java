package linkedList;

//https://www.interviewbit.com/problems/kth-node-from-middle/
public class KthNodeFromMiddle {
	/**
	 * Definition for singly-linked list. class ListNode { public int val; public
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */

	public int solve(ListNode head, int k) {
		if (head == null || head.next == null)
			return -1;
		ListNode middle = findMiddle(head);
		ListNode slow = head, fast = head;
		while (k-- != 0) {
			fast = fast.next;
			if (fast == middle && k != 0)
				return -1;
		}
		while (fast != middle) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.val;
	}

	private ListNode findMiddle(ListNode node) {
		ListNode slow, fast;
		slow = fast = node;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
