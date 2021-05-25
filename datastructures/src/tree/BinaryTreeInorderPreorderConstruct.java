package tree;

import java.util.ArrayList;
//https://www.youtube.com/watch?v=GeltTz3Z1rw
//The hardest part is to understand how to increment preIndex. To do that, for the left part, we 
//just do preIndex + 1. But for the right part, before this root, there might be subtrees in the 
//left side, so we can't just do preIndex + 2, we need to skip these left subtrees occurring just 
//before the inorder[index], so we do (index - instart) + preindex + 1 
//Explanation also around 11.02 and earlier too in the video
//Also you can store the indices of inorder against the values in a map to get O(1) time in 
//searching for the value in inorder

//https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/196/
//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
public class BinaryTreeInorderPreorderConstruct {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, inorder.length - 1, 0);
	}

	private TreeNode build(int[] preorder, int[] inorder, int inLow, int inHigh, int preStart) {
		if (inLow > inHigh)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		if (inLow == inHigh)
			return root;
		int index = findIndex(inorder, inLow, inHigh, root.val);
		root.left = build(preorder, inorder, inLow, index - 1, preStart + 1);
		root.right = build(preorder, inorder, index + 1, inHigh, preStart + index - inLow + 1);
		return root;
	}

	private int findIndex(int[] arr, int low, int high, int val) {
		for (int i = low; i <= high; i++)
			if (arr[i] == val)
				return i;
		return low;
	}

	public void printInorder(TreeNode root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.val);
		printInorder(root.right);
	}

//arraylist
	public TreeNode constructFromInorderPreorder(ArrayList<Integer> in, ArrayList<Integer> pre) {
		return constructTree(in, pre, 0, pre.size() - 1, 0);
	}

	private TreeNode constructTree(ArrayList<Integer> in, ArrayList<Integer> pre, int startIn, int endIn,
			int preIndex) {
		if (startIn > endIn)
			return null;

		TreeNode root = new TreeNode(pre.get(preIndex));
		if (startIn == endIn)
			return root;

		int inorderIndex = searchInorder(in, root.val);
		root.left = constructTree(in, pre, startIn, inorderIndex - 1, preIndex + 1);
		root.right = constructTree(in, pre, inorderIndex + 1, endIn, preIndex + inorderIndex - startIn + 1);
		return root;
	}

	private int searchInorder(ArrayList<Integer> in, Integer element) {
		return in.indexOf(element);
	}

}
