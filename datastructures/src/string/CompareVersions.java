package string;

//https://leetcode.com/problems/compare-version-numbers/
//https://www.interviewbit.com/problems/compare-version-numbers/
//https://www.geeksforgeeks.org/compare-version-numbers-large-inputs-allowed/
public class CompareVersions {

	public static int compareVersion(String a, String b) {
		int i = 0, j = 0;
		while (i < a.length() && j < b.length()) {
			int aIndex = getNextDotOrEndIndex(a, i);
			int bIndex = getNextDotOrEndIndex(b, j);

			String aPart = removeLeadingZeroes(a.substring(i, aIndex));
			String bPart = removeLeadingZeroes(b.substring(j, bIndex));

			if (aPart.length() < bPart.length())
				return -1;
			else if (aPart.length() > bPart.length())
				return 1;
			// System.out.println(bPart);
			if (aPart.compareTo(bPart) < 0)
				return -1;
			else if (aPart.compareTo(bPart) > 0)
				return 1;
			i = aIndex + 1;
			j = bIndex + 1;
		}
		while (i < a.length()) {
			int nextDotOrEnd = getNextDotOrEndIndex(a, i);
			String aPart = removeLeadingZeroes(a.substring(i, nextDotOrEnd));
			if (aPart.compareTo("0") > 0)
				return 1;
			i = nextDotOrEnd + 1;
		}
		while (j < b.length()) {
			int nextDotOrEnd = getNextDotOrEndIndex(b, j);
			String bPart = removeLeadingZeroes(b.substring(j, nextDotOrEnd));
			if (bPart.compareTo("0") > 0)
				return -1;
			j = nextDotOrEnd + 1;
		}
		return 0;
	}

	private static String removeLeadingZeroes(String a) {
		int i = 0;
		while (i < a.length() && a.charAt(i) == '0')
			i++;
		return a.substring(i, a.length());
	}

	private static int getNextDotOrEndIndex(String str, int curr) {
		while (curr < str.length() && str.charAt(curr) != '.')
			curr++;
		return curr;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("1", "1.10"));
		System.out.println(compareVersion("01", "1"));
	}

}
