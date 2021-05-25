package array.math;

//https://leetcode.com/problems/integer-to-english-words/solution/
public class IntegerToEnglishWords {

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		StringBuilder result = new StringBuilder();
		int place = 0;
		while (num > 0) {
			int rem = num % 1000;
			if (rem != 0) {
				String remStr = String.valueOf(rem);
				result = new StringBuilder(convertBlock(remStr, 0, remStr.length(), place)).append(result);
			}
			num /= 1000;
			place++;
		}
		return result.toString().trim();
	}

	private static String convertBlock(String remStr, int i, int n, int place) {
		// handling the last block - if single digit or two digits come separately
		StringBuilder str = new StringBuilder();
		if (n == 1 || n == 2) {
			if (n == 1)
				str.append(singleDigit(remStr.charAt(i)));
			if (n == 2) {
				// handling 20,30,40
				if (remStr.charAt(i + 1) == '0')
					str.append(tens(remStr.charAt(i)));
				// handling 12,13,14
				else if (remStr.charAt(i) == '1')
					str.append(lessThanTwenty(remStr.charAt(i + 1)));
				// handling rest of two digits like 23,67
				else
					str.append(tens(remStr.charAt(i)) + singleDigit(remStr.charAt(i + 1)));
			}
			if (place > 0)
				str.append(placePosition(place));
			return str.toString();
		}
		return singleDigit(remStr.charAt(i)) + "Hundred " + convertBlock(remStr, i + 1, n - 1, place);
	}

	private static String placePosition(int placeValue) {
		switch (placeValue) {
		case 0:
			return "Hundred ";
		case 1:
			return "Thousand ";
		case 2:
			return "Million ";
		case 3:
			return "Billion ";
		}
		return "";
	}

	private static String singleDigit(char num) {
		switch (num) {
		case '1':
			return "One ";
		case '2':
			return "Two ";
		case '3':
			return "Three ";
		case '4':
			return "Four ";
		case '5':
			return "Five ";
		case '6':
			return "Six ";
		case '7':
			return "Seven ";
		case '8':
			return "Eight ";
		case '9':
			return "Nine ";
		}
		return "";
	}

	private static String lessThanTwenty(int num) {
		switch (num) {
		case '1':
			return "Eleven ";
		case '2':
			return "Twelve ";
		case '3':
			return "Thirteen ";
		case '4':
			return "Fourteen ";
		case '5':
			return "Fifteen ";
		case '6':
			return "Sixteen ";
		case '7':
			return "Seventeen ";
		case '8':
			return "Eighteen ";
		case '9':
			return "Nineteen ";
		}
		return "";
	}

	private static String tens(int num) {
		switch (num) {
		case '1':
			return "Ten ";
		case '2':
			return "Twenty ";
		case '3':
			return "Thirty ";
		case '4':
			return "Forty ";
		case '5':
			return "Fifty ";
		case '6':
			return "Sixty ";
		case '7':
			return "Seventy ";
		case '8':
			return "Eighty ";
		case '9':
			return "Ninety ";
		}
		return "";
	}

	public static void main(String[] args) {
//		System.out.println(numberToWords(123));
//		System.out.println(numberToWords(1));
//		System.out.println(numberToWords(30));
//		System.out.println(numberToWords(23));
//		System.out.println(numberToWords(12));
//		System.out.println(numberToWords(1234));
//		System.out.println(numberToWords(123456));
//		System.out.println(numberToWords(1234567891));
//		System.out.println(numberToWords(0));
		System.out.println(numberToWords(1040));
		System.out.println(numberToWords(1000000000));
		System.out.println(numberToWords(1000000));
		System.out.println(numberToWords(100));
		System.out.println(numberToWords(1000));

	}
}
