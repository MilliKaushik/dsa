package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
public class MergeSortedLists {

	public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = head, current = head;
		if (l2 == null)
			return l1;
		if (l1 == null)
			return l2;
		while (l1 != null && l2 != null) {
			int val;
			if (l1.val <= l2.val) {
				val = l1.val;
				l1 = l1.next;
			} else {
				val = l2.val;
				l2 = l2.next;
			}
			if (current == null) {
				head = prev = current = new ListNode(val);
			} else {
				current = new ListNode(val);
				prev.next = current;
				prev = current;
			}
		}
		while (l1 != null) {
			current = new ListNode(l1.val);
			prev.next = current;
			prev = current;
			l1 = l1.next;
		}
		while (l2 != null) {
			current = new ListNode(l2.val);
			prev.next = current;
			prev = current;
			l2 = l2.next;
		}
		return head;
	}

	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val <= l2.val) {
			l1.next = mergeTwoListsRecursive(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoListsRecursive(l1, l2.next);
			return l2;
		}
	}

	// https://leetcode.com/explore/interview/card/top-interview-questions-hard/117/linked-list/839/
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
		ListNode first = lists[0];
		for (int i = 1; i < lists.length; i++) {
			ListNode second = lists[i];
			first = merge(first, second);
		}
		return first;
	}

	private ListNode merge(ListNode first, ListNode second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		ListNode curr1, curr2, head, prev = null;
		curr1 = first;
		curr2 = second;

		if (curr1.val <= curr2.val)
			head = curr1;
		else
			head = curr2;
		while (curr1 != null && curr2 != null) {
			if (curr1.val <= curr2.val) {
				if (prev != null)
					prev.next = curr1;
				prev = curr1;
				curr1 = curr1.next;
			} else {
				if (prev != null)
					prev.next = curr2;
				prev = curr2;
				curr2 = curr2.next;
			}
		}
		if (curr1 != null)
			prev.next = curr1;
		if (curr2 != null)
			prev.next = curr2;
		return head;
	}
}
