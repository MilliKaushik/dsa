package tree;

//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
public class BinaryTreeToDoublyLinkedList {

	private TreeNode headRef = null;

	// Function to convert binary tree to doubly linked list and return it.
	TreeNode bToDLL(TreeNode root) {
		bToDLLHelper(root, null);
		return headRef;
	}

	private TreeNode bToDLLHelper(TreeNode root, TreeNode prev) {
		if (root == null)
			return null;
		TreeNode left = bToDLLHelper(root.left, prev);
		if (left != null)
			prev = left;
		root.left = prev;
		if (prev != null)
			prev.right = root;
		if (headRef == null)
			headRef = root;
		TreeNode right = bToDLLHelper(root.right, root);
		if (right != null)
			return right;
		return root;
	}
}
