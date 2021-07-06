package linkedList;

//https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
//https://www.interviewbit.com/problems/list-cycle/
public class DetectCycleInList {

	public ListNode detectCycle(ListNode a) {
		ListNode slow, fast;
		slow = fast = a;
		fast = fast.next;
		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast) {
				return startLoop(a, slow);
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return null;
	}

	private ListNode startLoop(ListNode head, ListNode nodeInLoop) {
		ListNode current = nodeInLoop.next;
		int loopSize = 1;
		while (current != nodeInLoop) {
			loopSize++;
			current = current.next;
		}

		ListNode first = head;
		ListNode second = head;
		while (loopSize-- != 0)
			second = second.next;

		while (first != second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
}
