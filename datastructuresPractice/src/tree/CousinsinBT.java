package tree;

public class CousinsinBT {

	// https://leetcode.com/problems/cousins-in-binary-tree/
	// https://www.interviewbit.com/problems/cousins-in-binary-tree/
	// https://leetcode.com/problems/cousins-in-binary-tree/solution/
	public boolean isCousins(TreeNode root, int x, int y) {
		int h1 = height(root, x);
		int h2 = height(root, y);
		if (h1 != h2)
			return false;
		TreeNode p1 = findParent(root, x);
		TreeNode p2 = findParent(root, y);
		return p1 != p2;
	}

	private TreeNode findParent(TreeNode root, int a) {
		if (root == null)
			return null;
		if ((root.left != null && root.left.val == a) || (root.right != null && root.right.val == a))
			return root;
		TreeNode left = findParent(root.left, a);
		if (left != null)
			return left;
		return findParent(root.right, a);
	}

	private int height(TreeNode root, int a) {
		if (root == null)
			return 0;
		int ht = 0;
		if (root.val == a)
			return ht + 1;
		int leftHt = height(root.left, a);
		if (leftHt > 0)
			return leftHt + 1;
		int rightHt = height(root.right, a);
		if (rightHt > 0)
			return rightHt + 1;
		return ht;
	}
}
