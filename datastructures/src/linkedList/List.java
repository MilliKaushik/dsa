package linkedList;

public class List {

//https://www.interviewbit.com/problems/sort-binary-linked-list/
	public ListNode sortBinaryList(ListNode A) {
		ListNode head = A;
		if (head == null || head.next == null)
			return head;
		ListNode current = head;
		ListNode onesList = null;
		boolean isHeadSet = true;
		while (current != null) {
			if (current.val == 1) {
				if (head == current)
					isHeadSet = false;
				ListNode beginOne = current;
				current = getAllOneNodes(current);
				ListNode endOne = current;
				ListNode next = endOne.next;
				appendOneToList(onesList, beginOne, endOne);
				current.next = next;
			} else {
				if (!isHeadSet) {
					head = current;
					isHeadSet = true;
				}
			}
			current = current.next;
		}
		ListNode temp = head;
		while (temp != null && temp.val == 0) {
			temp = temp.next;
		}
		temp.next = onesList;
		return head;
	}

	private ListNode getAllOneNodes(ListNode current) {
		while (current.next != null && current.next.val == 1)
			current = current.next;
		return current;
	}

	private void appendOneToList(ListNode onesList, ListNode beginOne, ListNode endOne) {
		if (onesList == null)
			onesList = beginOne;
		else
			onesList.next = beginOne;
		endOne.next = null;
	}

}
