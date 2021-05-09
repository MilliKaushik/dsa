package array.search;

//https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
public class FloorCeiling {

	// O(N) time complexity
	public int getCeiling(int[] num, int x) {
		if (x <= num[0])
			return 0;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == x)
				return i;
			if (num[i] < x && num[i + 1] >= x)
				return i + 1;
		}
		return -1;
	}

	// O(N) time complexity --check
	public int getFloor(int[] num, int x) {
		int n = num.length;
		if (num[n - 1] <= x)
			return n - 1;
		for (int i = 1; i < n; i++) {
			if (num[i] == x)
				return i;
			if (num[i - 1] < x && num[i] >= x)
				return i;
		}
		return -1;
	}

	// O(logN) time complexity
	public int getCeilingBinarySearch(int[] num, int x) {
		int st = 0, end = num.length - 1;
		while (st < end) {
			;
		}
		return 0;
	}

	// O(logN) time complexity
	public int getFloorBinarySearch(int[] num, int x) {
		return 0;
	}
}
