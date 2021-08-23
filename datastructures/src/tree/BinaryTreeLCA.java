package tree;

//https://www.interviewbit.com/problems/least-common-ancestor/
//https://www.techiedelight.com/find-lowest-common-ancestor-lca-two-nodes-binary-tree/
//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class BinaryTreeLCA {

	// https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/181/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		if (left == null)
			return right;
		return left;
	}

	public TreeNode findLCANode(TreeNode root, TreeNode n1, TreeNode n2) {
		if (isNodePresentNode(root, n1) && isNodePresentNode(root, n2))
			return findLCAUtilNode(root, n1, n2);
		return null;
	}

	private boolean isNodePresentNode(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		return isNodePresentNode(root.left, node) || isNodePresentNode(root.right, node);
	}

	private TreeNode findLCAUtilNode(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null)
			return null;
		if (root == n1 || root == n2)
			return root;
		TreeNode left = findLCAUtilNode(root.left, n1, n2);
		TreeNode right = findLCAUtilNode(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		return null;
	}

	public TreeNode findLCAValue(TreeNode root, int n1, int n2) {
		if (isNodePresentValue(root, n1) && isNodePresentValue(root, n2))
			return findLCAUtilValue(root, n1, n2);
		return null;
	}

	private boolean isNodePresentValue(TreeNode root, int nodeValue) {
		if (root == null)
			return false;
		if (root.val == nodeValue)
			return true;
		return isNodePresentValue(root.left, nodeValue) || isNodePresentValue(root.right, nodeValue);
	}

	private TreeNode findLCAUtilValue(TreeNode root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.val == n1 || root.val == n2)
			return root;
		TreeNode left = findLCAUtilValue(root.left, n1, n2);
		TreeNode right = findLCAUtilValue(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

}
