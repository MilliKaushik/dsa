package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
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
