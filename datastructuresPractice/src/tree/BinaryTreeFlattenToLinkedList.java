package tree;

//https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
//https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
public class BinaryTreeFlattenToLinkedList {

	public TreeNode flatten(TreeNode root) {
		flattenUtil(root);
		return root;
	}

	private void flattenUtil(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			flattenUtil(root.left);
			moveLeftNode(root, root.left);
		}
		flattenUtil(root.right);
	}

	private void moveLeftNode(TreeNode root, TreeNode left) {
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		TreeNode current = root.right;
		while (current.right != null)
			current = current.right;
		current.right = temp;
	}

}
