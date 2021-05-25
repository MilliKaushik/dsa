package linkedList;

public class AddTwoNumbers2 {
	private int carry = 0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		int len1 = len(l1);
		int len2 = len(l2);
		int diff = Math.abs(len1 - len2);
		ListNode head = null, prev;
		if (diff == 0) {
			head = addTwoNumbersHelper(l1, l2);
		} else {
			if (len1 < len2) {
				ListNode temp = l1;
				l1 = l2;
				l2 = temp;
			}
			head = l1;
			prev = l1;
			while (diff-- != 0) {
				prev = l1;
				l1 = l1.next;
			}
			prev.next = addTwoNumbersHelper(l1, l2);
			handleCarry(head, prev);
		}
		if (carry != 0) {
			ListNode node = new ListNode(carry);
			node.next = head;
			head = node;
		}
		return head;
	}

	private void handleCarry(ListNode head, ListNode node) {
		if (node.next == head)
			return;
		handleCarry(head.next, node);
		head.val += carry;
		carry = head.val / 10;
		head.val %= 10;
	}

	private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;

		ListNode next = addTwoNumbersHelper(l1.next, l2.next);
		ListNode node = new ListNode(carry + l1.val + l2.val);
		carry = node.val / 10;
		node.val = node.val % 10;
		node.next = next;
		return node;
	}

	private int len(ListNode l) {
		return (l == null) ? 0 : 1 + len(l.next);
	}
}
