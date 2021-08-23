package array.math;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {

	public String intToRoman(int num) {
		Map<Integer, Character> intToRoman = new HashMap<>();
		intToRoman.put(1, 'I');
		intToRoman.put(5, 'V');
		intToRoman.put(10, 'X');
		intToRoman.put(50, 'L');
		intToRoman.put(100, 'C');
		intToRoman.put(500, 'D');
		intToRoman.put(1000, 'M');

		Map<Integer, String> specialNumbers = new HashMap<>();
		specialNumbers.put(4, "IV");
		specialNumbers.put(9, "IX");
		specialNumbers.put(40, "XL");
		specialNumbers.put(90, "XC");
		specialNumbers.put(400, "CD");
		specialNumbers.put(900, "CM");

		if (specialNumbers.containsKey(num))
			return specialNumbers.get(num);

		StringBuilder str = new StringBuilder();
		while (num > 0) {
			int noOfThousands = num % 1000;
			if (noOfThousands > 0) 
				append(str, noOfThousands, intToRoman.get(1000));
		;	
		
		}
		return "";
		}
	

	private void append(StringBuilder str, int noOfThousands, Character character) {
		// TODO Auto-generated method stub

	}
}
