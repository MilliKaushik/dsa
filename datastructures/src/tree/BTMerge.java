package tree;

public class BTMerge {

	// https://www.interviewbit.com/problems/merge-two-binary-tree/
	// https://www.geeksforgeeks.org/merge-two-binary-trees-node-sum/
	public TreeNode merge(TreeNode root1, TreeNode root2) {

		if (root1 == null)
			return root2;
		else if (root2 == null)
			return root1;

		TreeNode mergedNode = new TreeNode(root1.val + root2.val);

		mergedNode.left = merge(root1.left, root2.left);
		mergedNode.right = merge(root1.right, root2.right);
		return mergedNode;
	}

}
