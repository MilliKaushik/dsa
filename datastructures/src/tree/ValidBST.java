package tree;

public class ValidBST {
	TreeNode prev;

	// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	// https://www.interviewbit.com/problems/valid-binary-search-tree/
	// https://www.techiedelight.com/determine-given-binary-tree-is-a-bst-or-not/
	public boolean isValidBSTInorder(TreeNode root) {
		prev = null;
		return isValidBSTInorderUtil(root);
	}

	public boolean isValidBSTInorderUtil(TreeNode root) {
		if (root == null)
			return true;

		boolean left = isValidBSTInorderUtil(root.left);
		if (!left)
			return false;

		if (prev != null && root.val <= prev.val)
			return false;

		prev = root;
		return isValidBSTInorderUtil(root.right);
	}

	// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	public boolean isValidBSTMinMax(TreeNode root) {
		return isValidBSTMinMaxUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBSTMinMaxUtil(TreeNode root, int minValue, int maxValue) {
		if (root == null)
			return true;
		if (root.val < minValue || root.val > maxValue)
			return false;
		return isValidBSTMinMaxUtil(root.left, minValue, root.val - 1)
				&& isValidBSTMinMaxUtil(root.right, root.val + 1, maxValue);
	}
}
