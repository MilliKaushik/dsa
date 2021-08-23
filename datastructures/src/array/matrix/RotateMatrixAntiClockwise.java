package array.matrix;

//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
public class RotateMatrixAntiClockwise {

	public void rotateby90(int a[][]) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = a[n - 1 - j][i];
				a[n - 1 - j][i] = temp;
			}
		}
	}
}
