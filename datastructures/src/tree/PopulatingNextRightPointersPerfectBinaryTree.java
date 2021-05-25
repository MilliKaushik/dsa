package tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/192/
//See solution of LEETCODE
//https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
public class PopulatingNextRightPointersPerfectBinaryTree {

	private class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

//using level order traversal
	public Node connectExtraSpace(Node root) {
		if (root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- != 0) {
				Node node = queue.poll();
				if (size != 0)
					node.next = queue.peek();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return root;
	}

	// O(n) time and O(1) space
	public Node connectWithoutExtraSpaceIterative(Node root) {
		Node p = root, q = root;
		while (q != null) {
			while (p != null) {
				if (p.left != null) {
					if (p.right != null)
						p.left.next = p.right;
					else
						p.left.next = getNextRight(p);
				}
				if (p.right != null)
					p.right.next = getNextRight(p);

				p = p.next;
			}
			if (q.left != null)
				p = q.left;
			else if (q.right != null)
				p = q.right;
			else
				p = q.next;
			q = p;
		}
		return root;
	}

	private Node getNextRight(Node p) {
		Node q = p.next;
		while (q != null) {
			if (q.left != null)
				return q.left;
			if (q.right != null)
				return q.right;
			q = q.next;
		}
		return null;
	}

	// O(n) time and O(1) space
	public Node connectWithoutExtraSpaceRecursive(Node root) {
		if (root == null)
			return null;
		if (root.next != null)
			connectWithoutExtraSpaceRecursive(root.next);
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
				root.right.next = getNextRight(root);
			} else
				root.left.next = getNextRight(root);
			connectWithoutExtraSpaceRecursive(root.left);
		} else if (root.right != null) {
			root.right.next = getNextRight(root);
			connectWithoutExtraSpaceRecursive(root.right);
		} else
			connectWithoutExtraSpaceRecursive(getNextRight(root));
		return root;
	}
}
