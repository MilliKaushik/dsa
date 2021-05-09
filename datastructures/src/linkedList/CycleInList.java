package linkedList;

public class CycleInList {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast, slow;
		slow = head;
		fast = head.next;
		while (fast != null && fast.next != null) {
			if (fast == slow)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
