package tree;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
//https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
public class BinaryTreeFlattenToLinkedList {

	public TreeNode flatten1(TreeNode root) {
		flattenUtil1(root);
		return root;
	}

	private void flattenUtil1(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			flattenUtil1(root.left);
			moveLeftNode1(root, root.left);
		}
		flattenUtil1(root.right);
	}

	private void moveLeftNode1(TreeNode root, TreeNode left) {
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		TreeNode current = root.right;
		while (current.right != null)
			current = current.right;
		current.right = temp;
	}

	private TreeNode prev = null;

	public void flatten2(TreeNode root) {
		root = flattenUtil2(root);
	}

	private TreeNode flattenUtil2(TreeNode root) {
		if (root == null)
			return null;
		TreeNode t = new TreeNode(root.val);
		if (prev != null)
			prev.right = t;
		prev = t;
		TreeNode tLeft = flattenUtil2(root.left);
		if (tLeft != null)
			prev = tLeft;
		TreeNode tRight = flattenUtil2(root.right);
		if (tRight != null)
			prev = tRight;
		print(t);
		return t;
	}

	private void print(TreeNode t) {
		if (t != null) {
			System.out.println(t.val + " ");
			print(t.left);
			print(t.right);
		}
		System.out.println(" null");
	}
}
