package linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//https://leetcode.com/explore/interview/card/microsoft/32/linked-list/168/
public class CopyListWithRandomPointer {

	private static class Node {
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
	public static Node copyRandomListWithExtraSpace(Node head) {
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
	public static Node copyRandomListWithoutExtraSpace(Node head) {
		if (head == null)
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

	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(13);
		Node n3 = new Node(11);
		Node n4 = new Node(10);
		Node n5 = new Node(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		n1.random = null;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n1;
		Node output = copyRandomListWithoutExtraSpace(n1);
		System.out.println(output);
		printList(n1);
		System.out.println("----------------------");
		printList(output);
	}

	private static void printList(Node n) {
		while (n != null) {
			System.out.print("Node : " + n.val);
			if (n.next != null)
				System.out.print(" next : " + n.next.val);
			else
				System.out.print(" next : " + " null");
			if (n.random != null)
				System.out.print(" random : " + n.random.val);
			else
				System.out.print(" random : " + " null");
			n = n.next;
			System.out.println();
		}
	}
}
