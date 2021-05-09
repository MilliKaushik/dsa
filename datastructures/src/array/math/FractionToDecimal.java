package array.math;

public class FractionToDecimal {
	private static final int TWO = 2;
	private static final int FIVE = 5;

	public String fractionToDecimal(int numerator, int denominator) {
		boolean isDenFactorOfTwoOrFive = getDenFactor(denominator);
		double quotient = (double) numerator / denominator;
		if (isDenFactorOfTwoOrFive)
			return quotient + "";
		else {
			String str = quotient + "";
			String postDecimal = str.substring(str.indexOf('.') + 1, str.length());
			int i = 0, j = 0;
			while (true) {
				String current = postDecimal.substring(i, j + 1);
				if (current.equals(postDecimal.substring(j + 1, j + 1 + current.length()))) {
					str.concat(postDecimal.substring(i, j));
					break;
				} else
					j++;
			}
		}
		return "";
	}

	private boolean getDenFactor(int number) {
		if (number % TWO == 0)
			number /= TWO;
		if (number % FIVE == 0)
			number /= FIVE;
		return number == 1;
	}
}
