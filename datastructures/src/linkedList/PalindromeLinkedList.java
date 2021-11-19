package linkedList;

import java.util.Stack;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
public class PalindromeLinkedList {

	static ListNode left;

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		left = l1;
		System.out.println(lPalin(l1));
	}
	
	
	public static int lPalin(ListNode head) {
		if (head == null)
			return 1;
		int isp = lPalin(head.next);
		if (isp == 0)
			return 0;
		int isp1 = (left.val == head.val) ? 1 : 0;
		left = left.next;
		return isp1;
	}

	public boolean isPalindromeStack1(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		int length = length(head);
		ListNode current = head;
		int halfLength = length % 2 == 0 ? length / 2 : length / 2 + 1;
		while (halfLength-- != 0) {
			if (length % 2 != 0 && halfLength == 0) {
				current = current.next;
				break;
			}
			stack.push(current.val);
			current = current.next;
		}
		while (current != null) {
			int top = stack.pop();
			if (top != current.val)
				return false;
			current = current.next;
		}
		return true;
	}

	private int length(ListNode current) {
		int count = 0;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public boolean isPalindromeStack2(ListNode head) {
		ListNode current;
		current = head;
		Stack<Integer> stack = new Stack<>();
		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}

		current = head;
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (current.val != top)
				return false;
			else
				current = current.next;
		}
		return true;
	}
}