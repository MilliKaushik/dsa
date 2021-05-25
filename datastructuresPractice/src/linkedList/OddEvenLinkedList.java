package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/
public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prevOdd = head;
		ListNode prevEven = head.next;
		ListNode evenHead = head.next;
		ListNode curr = head.next.next;
		int count = 3;
		while (curr != null) {
			if (count % 2 == 0) {
				prevEven.next = curr;
				prevEven = curr;
			} else if (count % 2 != 0) {
				prevOdd.next = curr;
				prevOdd = curr;
			}
			curr = curr.next;
			count++;
		}
		prevEven.next = null;
		prevOdd.next = evenHead;
		return head;
	}
}
