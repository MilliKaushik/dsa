package recursion;

//https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
//https://leetcode.com/problems/k-th-symbol-in-grammar/
public class KthSymbolInGrammar {

	public int kthGrammar1(int n, int k) {
		if (n == 1 && k == 1)
			return 0;
		int len = (int) Math.pow(2, n - 1);
		if (k <= len / 2)
			return kthGrammar1(n - 1, k);
		else
			return kthGrammar1(n - 1, k - len / 2) == 0 ? 1 : 0;
	}

	// Passed 51/55 test cases - NOT CORRECT
	public int kthGrammar2(int n, int k) {
		if (n == 1 && k == 1)
			return 0;
		if (n == 2 && k == 1)
			return 0;
		if (n == 2 && k == 2)
			return 1;
		if (k % 2 == 0) {
			int a = kthGrammar2(n - 1, k / 2);
			if (a == 0)
				return 0;
			else
				return 1;
		} else {
			int a = kthGrammar2(n - 1, k / 2 + 1);
			if (a == 0)
				return 0;
			else
				return 1;
		}
	}
}
