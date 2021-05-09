package tree;

//https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/ - some error
//https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
public class BSTSortedArrayToBalancedTree {

	public TreeNode sortedArrayToBST(final int[] sortedArray) {
		return sortedArrayToBSTUtil(sortedArray, 0, sortedArray.length - 1);
	}

	private TreeNode sortedArrayToBSTUtil(int[] sortedArray, int start, int end) {
		if (start > end)
			return null;
		int rootIndex = (start + end) / 2;
		TreeNode root = new TreeNode(sortedArray[rootIndex]);
		root.left = sortedArrayToBSTUtil(sortedArray, start, rootIndex - 1);
		root.right = sortedArrayToBSTUtil(sortedArray, rootIndex + 1, end);
		return root;
	}

}
