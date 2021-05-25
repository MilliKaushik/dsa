package tree;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
public class MaximumDepthOfTree {

	TreeNode prev;

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrToBSTHelper(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrToBSTHelper(int[] nums, int st, int end) {
		if (st > end)
			return null;
		int mid = st + (end - st) / 2;
		TreeNode t = new TreeNode(nums[mid]);
		t.left = sortedArrToBSTHelper(nums, st, mid - 1);
		t.right = sortedArrToBSTHelper(nums, mid + 1, end);
		return t;
	}

	public boolean isValidBST(TreeNode root) {
		prev = null;
		return isValidBSTHelper(root);
	}

	private boolean isValidBSTHelper(TreeNode root) {
		if (root == null)
			return true;
		boolean isLeftValidBST = isValidBSTHelper(root.left);
		if (prev != null && prev.val >= root.val)
			return false;
		prev = root;
		return isLeftValidBST && isValidBSTHelper(root.right);
	}

	public boolean isSymmetric(TreeNode root) {
		return isSymmetricHelper(root.left, root.right);
	}

	private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}
}
