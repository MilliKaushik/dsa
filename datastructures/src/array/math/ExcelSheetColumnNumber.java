package array.math;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/817/
public class ExcelSheetColumnNumber {

	public int titleToNumber(String columnTitle) {
		int alphabetSize = 26;
		int len = columnTitle.length() - 1;
		int colNumber = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			colNumber += ((int) Math.pow(alphabetSize, len) * (columnTitle.charAt(i) - 'A' + 1));
			len--;
		}
		return colNumber;
	}
}
