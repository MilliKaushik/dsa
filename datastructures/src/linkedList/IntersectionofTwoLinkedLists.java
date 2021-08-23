package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/
//https://www.interviewbit.com/problems/intersection-of-linked-lists/
//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
//This is the difference solution, another can be make a loop solution
public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int sizeA = size(a);
		int sizeB = size(b);
		if (sizeA < sizeB) {
			ListNode temp = a;
			a = b;
			b = temp;
		}
		int diff = Math.abs(sizeA - sizeB);
		while (diff-- != 0)
			a = a.next;
		return getIntersection(a, b);
	}

	private int size(ListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	private ListNode getIntersection(ListNode a, ListNode b) {
		if (a == b)
			return a;
		if (a == null || b == null)
			return null;
		return getIntersection(a.next, b.next);
	}

	public ListNode getIntersectionNode1(ListNode l1, ListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);

		ListNode larger, smaller;
		if (len1 > len2) {
			larger = l1;
			smaller = l2;
		} else {
			larger = l2;
			smaller = l1;
		}

		int diff = Math.abs(len1 - len2);
		while (diff != 0) {
			larger = larger.next;
			diff--;
		}
		while (larger != null || smaller != null) {
			if (larger == smaller)
				return larger;
			larger = larger.next;
			smaller = smaller.next;
		}
		return null;
	}

	private int length(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	public ListNode getIntersectionNode2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode curr1 = l1;
		int count1 = 1;
		while (curr1.next != null) {
			count1++;
			curr1 = curr1.next;
		}
		curr1.next = l1;

		ListNode first = l2;

		while (first != null && count1-- != 0) {
			first = first.next;
			if (first == null) {
				curr1.next = null;
				return null;
			}
		}

		ListNode second = l2;
		while (first != null && second != null) {
			if (first == second) {
				curr1.next = null;
				return first;
			}
			first = first.next;
			second = second.next;
		}
		curr1.next = null;
		return null;
	}
}
