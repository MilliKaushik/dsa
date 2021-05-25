package array.math;

//https://leetcode.com/problems/excel-sheet-column-title/
//https://leetcode.com/problems/excel-sheet-column-title/discuss/51399/Accepted-Java-solution
public class ExcelSheetColumnTitle {
	private static final int BASE = 26;

	public static String convertToTitle1(int columnNumber) {
		StringBuilder str = new StringBuilder();

		while (columnNumber > 0) {
			columnNumber--;
			str.insert(0, ((char) ('A' + (columnNumber % BASE))));
			columnNumber /= BASE;
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle1(1));
		System.out.println(convertToTitle1(26));
		System.out.println(convertToTitle1(28));
		System.out.println(convertToTitle1(701));
		System.out.println(convertToTitle1(2147483647));
	}
}
