package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
//https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
//https://www.geeksforgeeks.org/remove-nth-node-from-end-of-the-linked-list/
//https://www.geeksforgeeks.org/delete-nth-node-from-the-end-of-the-given-linked-list/
public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEndOptimized(ListNode head, int n) {
		ListNode slow, fast;
		slow = fast = head;
		while (n-- != 0 && fast != null)
			fast = fast.next;
		// assuming that if n is greater than size of list, we need to remove head
		if (fast == null)
			return head.next;
		while (fast != null) {
			if (fast.next == null) {
				if (slow == head)
					head = head.next;
				slow.next = slow.next.next;
				return head;
			}
			slow = slow.next;
			fast = fast.next;
		}
		if (fast == null)
			return head.next;
		return head;
	}

	public ListNode removeNthFromEndBruteForce(ListNode head, int n) {
		int length = size(head);
		if (n > length)
			return null;
		int nthFromStart = length - n + 1;
		ListNode curr = head;
		ListNode prev = curr;
		while (nthFromStart-- != 0) {
			if (nthFromStart == 0) {
				if (curr == head)
					head = head.next;
				else
					prev.next = curr.next;
			}
			prev = curr;
			curr = curr.next;
		}
		return head;
	}

	private int size(ListNode head) {
		ListNode curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
}
