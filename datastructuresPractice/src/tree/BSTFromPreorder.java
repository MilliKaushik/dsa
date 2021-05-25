package tree;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/solution/
public class BSTFromPreorder {

	// O(nlogn) time solution and O(1) space
	public static TreeNode bstFromPreorder1(int[] preorder) {
		return bstFromPreorderHelper1(preorder, 0, preorder.length - 1);
	}

	private static TreeNode bstFromPreorderHelper1(int[] preorder, int st, int end) {
		if (st > end)
			return null;
		TreeNode root = new TreeNode(preorder[st]);
		if (st == end)
			return root;
		int index = findNextGreater(preorder, st + 1, end, root.val);
		root.left = index != -1 ? bstFromPreorderHelper1(preorder, st + 1, index - 1)
				: bstFromPreorderHelper1(preorder, st + 1, end);
		root.right = index != -1 ? bstFromPreorderHelper1(preorder, index, end) : null;
		return root;
	}

	private static int findNextGreater(int[] arr, int low, int high, int x) {
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (x > arr[mid])
				low = mid + 1;
			else {
				result = mid;
				high = mid - 1;
			}
		}
		return result;
	}

	private static int preIndex = 0;

	// O(n) time and O(1) space
	public static TreeNode bstFromPreorder2(int[] preorder) {
		return bstFromPreorderHelper2(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static TreeNode bstFromPreorderHelper2(int[] preorder, int min, int max) {
		if (preIndex == preorder.length || preorder[preIndex] < min || preorder[preIndex] > max)
			return null;
		TreeNode root = new TreeNode(preorder[preIndex]);
		preIndex++;
		root.left = bstFromPreorderHelper2(preorder, min, root.val);
		root.right = bstFromPreorderHelper2(preorder, root.val, max);
		return root;
	}

	public static void main(String[] args) {
		System.out.println(bstFromPreorder1(new int[] { 8, 5, 1, 7, 10, 12 }));
	}
}
