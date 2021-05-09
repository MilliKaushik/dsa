package stack.stackapplications;

//https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9
//https://leetcode.com/problems/trapping-rain-water/
public class RainWaterTrapping {

	public int trap(int[] height) {
		int n = height.length;
		if (n == 0)
			return 0;
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];
		maxLeft[0] = height[0];
		for (int i = 1; i < n; i++)
			maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);

		maxRight[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--)
			maxRight[i] = Math.max(maxRight[i + 1], height[i]);

		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
		return sum;
	}
}
