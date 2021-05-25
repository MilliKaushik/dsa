package array.misc;

//https://www.youtube.com/watch?v=tSRFtR3pv74
//https://leetcode.com/problems/product-of-array-except-self/
//https://www.geeksforgeeks.org/a-product-array-puzzle/
public class ProductArrayPuzzle {

	// O(n) space complexity O(n) time complexity
	public int[] printProductArrayWithExtraSpace(int[] num) {
		int n = num.length;
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		int[] product = new int[n];

		prefix[0] = suffix[n - 1] = 1;
		for (int i = 1; i < n; i++)
			prefix[i] = prefix[i - 1] * num[i - 1];

		for (int i = n - 2; i >= 0; i--)
			suffix[i] = suffix[i + 1] * num[i + 1];

		for (int i = 0; i < n; i++)
			product[i] = prefix[i] * suffix[i];

		return product;
	}

	// O(1) space complexity O(n) time complexity
	public int[] printProductArrayWithoutExtraSpace(int[] num) {
		int n = num.length;
		int[] product = new int[n];

		product[0] = 1;
		for (int i = 1; i < n; i++)
			product[i] = product[i - 1] * num[i - 1];

		int suffix = 1;
		for (int i = n - 2; i >= 0; i--) {
			suffix *= num[i + 1];
			product[i] *= suffix;
		}
		return product;
	}

}
