package tree;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode(int x) { val = x; left=null; right=null; } }
	 */

	public int[] solve(TreeNode root, int k) {
		List<Integer> resultList = new ArrayList<>();
		int depth = findDepth(root, k);
		addCousins(root, null, depth, k, resultList);
		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++)
			result[i] = resultList.get(i);
		return result;
	}

	private void addCousins(TreeNode root, TreeNode parent, int depth, int k, List<Integer> resultList) {
		if (root == null)
			return;
		if (depth == 1 && parent != null) {
			boolean isNotLeftSibling = false;
			if (parent.left == null)
				isNotLeftSibling = true;
			else if (parent.left.val != k)
				isNotLeftSibling = true;

			boolean isNotRightSibling = false;
			if (parent.right == null)
				isNotRightSibling = true;
			else if (parent.right.val != k)
				isNotRightSibling = true;

			if (root.val != k && isNotLeftSibling && isNotRightSibling)
				resultList.add(root.val);
			return;
		}
		addCousins(root.left, root, depth - 1, k, resultList);
		addCousins(root.right, root, depth - 1, k, resultList);
	}

	private int findDepth(TreeNode root, int k) {
		if (root == null)
			return 0;
		if (root.val == k)
			return 1;

		int left = findDepth(root.left, k);
		if (left != 0)
			return 1 + left;

		int right = findDepth(root.right, k);
		if (right != 0)
			return 1 + right;

		return 0;
	}
}
