package linkedList;

//https://www.interviewbit.com/problems/sort-binary-linked-list/
public class SortBinaryList {

	public ListNode solve(ListNode a) {
		int countOfZero = 0;
		int countOfOne = 0;
		while (a != null) {
			if (a.val == 0)
				countOfZero++;
			else
				countOfOne++;
			a = a.next;
		}
		ListNode newHead = createList(countOfZero, 0);
		ListNode current = newHead;
		while (current.next != null)
			current = current.next;
		current.next = createList(countOfOne, 1);
		return newHead;
	}

	private ListNode createList(int count, int val) {
		ListNode st = null, prev = null;
		while (count-- != 0) {
			ListNode node = new ListNode(val);
			if (prev != null)
				prev.next = node;
			if (st == null)
				st = node;
			prev = node;
		}
		return st;
	}

}
