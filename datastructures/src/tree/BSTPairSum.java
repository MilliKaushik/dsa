package tree;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/2sum-binary-tree/
//https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
public class BSTPairSum {

	// O(n) space and time
	public boolean isPairSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		List<TreeNode> inorder = new ArrayList<>();
		treeToList(root, inorder);
		int start = 0;
		int end = inorder.size() - 1;
		while (start < end) {
			if (inorder.get(start).val + inorder.get(end).val == sum)
				return true;
			if (inorder.get(start).val + inorder.get(end).val > sum)
				end--;
			else
				start++;
		}
		return false;
	}

	private void treeToList(TreeNode root, List<TreeNode> inorder) {
		if (root == null)
			return;
		treeToList(root.left, inorder);
		inorder.add(root);
		treeToList(root.right, inorder);
	}

}
