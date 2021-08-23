package tree;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/recover-binary-search-tree/
//https://www.interviewbit.com/problems/recover-binary-search-tree/
//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
public class RecoverBinarySearchTree {
	TreeNode first, middle, last, prev;

	public ArrayList<Integer> recoverTree(TreeNode root) {
		inorderTraversal(root);
		if (last == null)
			return new ArrayList<>(Arrays.asList(middle.val, first.val));
		return new ArrayList<>(Arrays.asList(last.val, first.val));
	}

	private void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		if (prev != null) {
			if (prev.val >= root.val) {
				if (first == null) {
					first = prev;
					middle = root;
				} else {
					last = root;
				}
			}
		}
		prev = root;

		inorderTraversal(root.right);
	}
}
