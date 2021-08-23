package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
public class AddTwoNumbers1 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		int sum, carry = 0;
		ListNode head = null, prev = null;
		while (curr1 != null || curr2 != null) {
			sum = (curr1 != null ? curr1.val : 0) + (curr2 != null ? curr2.val : 0) + carry;
			carry = sum / 10;
			sum %= 10;
			ListNode node = new ListNode(sum);
			if (head == null)
				head = node;
			else
				prev.next = node;
			prev = node;
			if (curr1 != null)
				curr1 = curr1.next;
			if (curr2 != null)
				curr2 = curr2.next;
		}
		if (carry > 0) {
			ListNode node = new ListNode(carry);
			prev.next = node;
		}
		return head;
	}
}
