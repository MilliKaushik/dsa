package linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//https://leetcode.com/explore/interview/card/microsoft/32/linked-list/168/
public class CopyListWithRandomPointer {

	private class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	// https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
	public Node copyRandomListWithExtraSpace(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			map.put(curr, new Node(curr.val));
			curr = curr.next;
		}
		Node newHead = map.get(head);
		for (Entry<Node, Node> entry : map.entrySet()) {
			Node orig = entry.getKey();
			Node copied = entry.getValue();
			copied.next = map.get(orig.next);
			copied.random = map.get(orig.random);
		}
		return newHead;
	}

	// https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
	public Node copyRandomListWithoutExtraSpace(Node head) {
		if(head == null)
			return head;
		Node curr = head;
		while (curr != null) {
			Node node = new Node(curr.val);
			node.next = curr.next;
			curr.next = node;
			curr = node.next;
		}
		Node newHead = head.next;
		curr = head;
		while (curr != null) {
			if (curr.random != null)
				curr.next.random = curr.random.next;
			else
				curr.next.random = null;
			curr = curr.next.next;
		}
		curr = head;
		while (curr.next.next != null) {
			Node origNext = curr.next.next;
			curr.next.next = curr.next.next.next;
			curr.next = origNext;
			curr = origNext;
		}
		curr.next.next = null;
		curr.next = null;
		return newHead;
	}
}
