package array.search;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
//https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
public class AppearingOnce {

	public int getAppearingOnce(int[] num) {
		int xor = num[0];
		for (int i = 1; i < num.length; i++)
			xor ^= num[i];
		return xor;
	}
}
