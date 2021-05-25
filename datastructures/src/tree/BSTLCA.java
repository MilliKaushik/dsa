package tree;

//https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/182/
//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
public class BSTLCA {

	public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if (isNodePresent(root, n1) && isNodePresent(root, n2))
			return findLCAUtil(root, n1, n2);
		return null;
	}

	private boolean isNodePresent(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		return isNodePresent(root.left, node) || isNodePresent(root.right, node);
	}

	private TreeNode findLCAUtil(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null)
			return null;
		if (root.val > n1.val && root.val > n2.val)
			return findLCAUtil(root.left, n1, n2);
		if (root.val < n1.val && root.val < n2.val)
			return findLCAUtil(root.right, n1, n2);
		return root;
	}

}
