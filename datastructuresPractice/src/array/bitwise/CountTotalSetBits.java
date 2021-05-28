package array.bitwise;

//https://www.interviewbit.com/problems/count-total-set-bits/
public class CountTotalSetBits {

	// brute force
	public static int solve1(int A) {
		int k = 0;
		for (int i = 1; i <= A; i++) {
			for (int j = 0; j < 32; j++)
				if ((i & (1 << j)) != 0)
					k++;
		}
		return k;
	}

	public static int solve2(int A) {
		int powOfTwo = getHighestPowerOfTwo(A);
		int k = 0;
		int i = (int)Math.pow(2, powOfTwo) + 1;
		for(;i <= A; i++)
			for(int j = 0; j < 32; j++)
				if((i & (1 << j)) != 0)
						k++;
				
		while (powOfTwo > 0) {
			int diff = (int) (Math.pow(2, powOfTwo) - Math.pow(2, powOfTwo - 1));
			k += diff;
			k += (diff * (powOfTwo - 1)) / 2;
			powOfTwo--;
		}
		
		return k + 1;
	}

	private static int getHighestPowerOfTwo(int a) {
		int x = 0;
		for (int i = 0; i < 32; i++)
			if ((a & (1 << i)) != 0)
				x = i;
		return x;
	}

	public static void main(String[] args) {
		System.out.println(solve1(1));
		System.out.println(solve1(2));
		System.out.println(solve1(3));
		System.out.println(solve1(4));

		System.out.println(solve2(1));
		System.out.println(solve2(2));
		System.out.println(solve2(3));
		System.out.println(solve2(4));
	}
}
