package recursion;

//https://www.youtube.com/watch?v=l45md3RYX7c
//if you want to count then
public class TowerOfHanoi {
	private static int count = 0;

	public void solve(int s, int d, int h, int n) {
		count++;
		if (n == 1) {
			System.out.println("Moving from " + s + " to " + " d");
			return;
		}
		// moving n - 1 disc from s to h using d as helper
		solve(s, h, d, n - 1);
		// moving that one disc from s to d
		System.out.println("Moving from " + s + " to " + d);
		solve(h, d, s, n - 1);
	}
}
