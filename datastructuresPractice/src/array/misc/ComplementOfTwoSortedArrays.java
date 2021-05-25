package array.misc;

//https://www.geeksforgeeks.org/find-relative-complement-two-sorted-arrays/
public class ComplementOfTwoSortedArrays {

	public int[] complement(int[] arr1, int[] arr2) {
		int[] com = new int[arr1.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				com[k++] = arr1[i++];
			} else
				j++;
		}
		while (i < arr1.length)
			com[k++] = arr1[i++];
		return com;
	}
}
