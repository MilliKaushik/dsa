package array.math;

//https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm#:~:text=Recall%20that%20the%20Greatest%20Common,the%20GCD%20of%20two%20integers.
public class HCF {

	public int hcf(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a == b)
			return a;
		if (a > b)
			return hcf(a - b, b);
		return hcf(a, b - a);
	}

	public int hcfOfArrayNumbers(int[] arr) {
		if (arr.length == 1)
			return arr[0];
		int currentHcf = hcf(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			currentHcf = hcf(currentHcf, arr[i]);
			if (currentHcf == 1)
				return 1;
		}
		return currentHcf;
	}
}
