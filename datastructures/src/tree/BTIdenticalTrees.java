package tree;

//https://leetcode.com/problems/same-tree/
//https://www.interviewbit.com/problems/identical-binary-trees/
public class BTIdenticalTrees {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if ((p == null || q == null) || (p.val != q.val))
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
