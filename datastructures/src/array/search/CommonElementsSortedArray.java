package array.search;

//https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
public class CommonElementsSortedArray {

	public int[] getCommon(int[] num1, int[] num2, int[] num3) {
		int n1 = num1.length;
		int n2 = num2.length;
		int n3 = num3.length;
		int[] commonList = new int[n1 + n2 + n3];
		int i = 0, j = 0, k = 0, m = 0;
		while (i < n1 && j < n2 && k < n3) {
			if (num1[i] == num2[j] && num2[j] == num3[k]) {
				commonList[m++] = num1[i];
				i++;
				j++;
				k++;
			} else if (num1[i] < num2[j])
				i++;
			else if (num1[j] < num2[k])
				j++;
			else
				k++;
		}
		return commonList;
	}
}
