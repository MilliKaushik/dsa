package array.math;

//https://app.codility.com/c/run/trainingY7XHW4-XME/
public class CountDivisible {

	public int solution(int a, int b, int k) {
		int i = 0;
		for (i = a; i <= b; i++)
			if (i % k == 0)
				break;
		if (i == b + 1)
			return 0;
		return (b - i) / k + 1;
	}
}
