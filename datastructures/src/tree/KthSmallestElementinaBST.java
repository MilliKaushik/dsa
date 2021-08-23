package tree;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
public class KthSmallestElementinaBST {

	private int count = 1;

	public int kthSmallest(TreeNode root, int k) {
		return inorder(root, k);
	}

	private int inorder(TreeNode root, int k) {
		if (root == null)
			return -1;
		int val = inorder(root.left, k);
		if (val != -1)
			return val;
		if (count == k)
			return root.val;
		count++;
		return inorder(root.right, k);
	}
}
