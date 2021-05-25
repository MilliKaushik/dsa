package array.sort;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
public class SortColours {

	private static final int RED = 0;
	private static final int WHITE = 1;
	private static final int BLUE = 2;

	// two pass
	public void sortColors1(int[] nums) {
		int redCount = 0;
		int whiteCount = 0;
		int blueCount = 0;
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case RED:
				redCount++;
				break;
			case WHITE:
				whiteCount++;
				break;
			case BLUE:
				blueCount++;
				break;
			}
		}

		int i = 0;
		while (redCount-- != 0)
			nums[i++] = RED;
		while (whiteCount-- != 0)
			nums[i++] = WHITE;
		while (blueCount-- != 0)
			nums[i++] = BLUE;
	}

	// single pass
	public void sortColors2(int[] nums) {
		int n = nums.length;
		int i = 0;
		int j = n - 1;
		int currColor = RED;
		while (true) {
			while (i < j && nums[i] != currColor) {
				if (nums[j] != currColor)
					j--;
				else
				swap(nums, i, j);
			}
			if (i == j) {
				currColor++;
				if (currColor == BLUE || i == n - 1) 
					break;
				j = n - 1;
				continue;
			}
			j = n - 1;
			i++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
