package tree;

public class BinaryTreeMirrorTree {

	// https://www.interviewbit.com/problems/symmetric-binary-tree/
	// https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
	public int isSymmetric(TreeNode root) {
		return isMirror(root.left, root.right);
	}

	private int isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return 1;
		if (left == null || right == null)
			return 0;
		if (left.val != right.val)
			return 0;
		if (isMirror(left.left, right.right) != 1)
			return 0;
		return isMirror(left.right, right.left);
	}
}
