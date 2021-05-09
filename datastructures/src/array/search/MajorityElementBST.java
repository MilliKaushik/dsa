package array.search;

//https://www.geeksforgeeks.org/majority-element/ TIME LIMIT EXCEEDED SOLUTION
public class MajorityElementBST {

	static int maxCount = 0;

	static class Node {
		int data;
		Node left;
		Node right;
		int freq;
		Node root;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.freq = 1;
		}

		public static Node insert(Node root, int data) {
			Node newNode = new Node(data);
			if (root == null) {
				root = newNode;
				return root;
			}
			if (root.data > data)
				root = insert(root.left, data);
			else if (root.data < data)
				root = insert(root.right, data);
			else {
				root.freq++;
				maxCount = Math.max(root.freq, maxCount);
			}
			return root;
		}
	}

	public static int getMajority(int[] num) {
		Node root = null;
		for (int i = 0; i < num.length; i++) {
			root = Node.insert(root, num[i]);
		}
		if (maxCount > num.length / 2)
			return checkMajorityElement(root, num.length);
		else
			return -1;
	}

	private static int checkMajorityElement(Node root, int n) {
		while (root != null) {
			checkMajorityElement(root.left, n);
			if (root.freq > n / 2)
				return root.data;
			checkMajorityElement(root.right, n);
		}
		return -1;
	}
}
