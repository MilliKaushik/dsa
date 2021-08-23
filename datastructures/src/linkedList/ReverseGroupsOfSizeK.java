package linkedList;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseGroupsOfSizeK {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newHead = null, prev = null, curr = head, st = head;
		int currK = k;
		while (curr != null) {
			if (currK == 1) {
				ListNode next = curr.next;
				reverse(st, curr);
				if (prev != null)
					prev.next = curr;
				if (newHead == null)
					newHead = curr;
				st.next = next;
				prev = st;
				st = next;
				currK = k;
				curr = next;
			} else {
				currK--;
				curr = curr.next;
			}
		}
		return newHead;
	}

	private void reverse(ListNode node, ListNode end) {
		if (node == end)
			return;
		reverse(node.next, end);
		node.next.next = node;
		node.next = null;
	}
}
