package tree;

//https://leetcode.com/problems/unique-binary-search-trees/
//https://www.interviewbit.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTree {

	public static int numTrees(int n) {
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++)
			arr[i - 1] = i - 1;

		int[][] t = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				t[i][j] = -1;

		int count = 0;
		for (int i = n - 1; i >= 0; i--)
			count += create(arr, 0, n - 1, i, t);
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				System.out.print("t[" + i + "]" + "[" + j + "]" + ":" + t[i][j] + " ");
			System.out.println();
		}
		return count;
	}

	private static int create(int[] arr, int st, int end, int index, int[][] t) {
		if (st > end || st < 0 || end >= arr.length)
			return 0;

		if (t[st][end] != -1)
			return t[st][end];
		if (st == end) {
			t[st][end] = 1;
			return 1;
		}

		int countLeft = 0;
		for (int i = index - 1; i >= st; i--)
			countLeft += create(arr, st, index - 1, i, t);

		int countRight = 0;
		for (int i = end; i > index; i--)
			countRight += create(arr, index + 1, end, i, t);

		if (countLeft == 0)
			t[st][end] = countRight;
		else if (countRight == 0)
			t[st][end] = countLeft;
		else
			t[st][end] = countLeft * countRight;
		return t[st][end];
	}

	public static void main(String[] args) {
		// System.out.println(numTrees(1));
		// System.out.println(numTrees(2));
		System.out.println(numTrees(3));
	}
}
