package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
public class DeleteNodeinaLinkedList {

	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		ListNode nextNext = node.next.next;
		node.val = next.val;
		node.next = nextNext;
	}
}
