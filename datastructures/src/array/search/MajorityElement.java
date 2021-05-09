package array.search;

//https://www.geeksforgeeks.org/majority-element/
public class MajorityElement {

	// Below approach assumes that majority element always exists and doesn't check
	// for it
	public int majorityElement(int[] nums) {
		int n = nums.length;
		int count = 1;
		int majorityElement = nums[0];
		for (int i = 1; i < n; i++) {
			if (nums[i] == majorityElement)
				count++;
			else
				count--;
			if (count == 0) {
				majorityElement = nums[i];
				count = 1;
			}
		}
		return majorityElement;
	}

	private class Node {
		private int value;
		private int freq;
		private Node left;
		private Node right;

		private Node(int value) {
			this.value = value;
			freq = 1;
		}
	}

	private Node root;
	int max, majorityElement;

	public int majorityElementBST(int[] nums) {
		int n = nums.length;
		majorityElement = -1;
		max = 0;
		for (int i = 0; i < n; i++)
			root = insert(root, nums[i]);
		if (max > n / 2)
			return majorityElement;
		return -1;
	}

	private Node insert(Node root, int val) {
		if (root == null)
			root = new Node(val);
		else {
			if (root.value == val) {
				root.freq++;

			} else if (root.value > val)
				root.left = insert(root.left, val);
			else
				root.right = insert(root.right, val);
		}
		if (max < root.freq) {
			max = root.freq;
			majorityElement = val;
		}
		return root;
	}
}
