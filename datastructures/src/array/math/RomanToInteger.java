package array.math;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/
public class RomanToInteger {
	private static final Map<Character, Integer> ROMAN_SYMBOLS;
	static {
		ROMAN_SYMBOLS = new HashMap<>();
		ROMAN_SYMBOLS.put('I', 1);
		ROMAN_SYMBOLS.put('V', 5);
		ROMAN_SYMBOLS.put('X', 10);
		ROMAN_SYMBOLS.put('L', 50);
		ROMAN_SYMBOLS.put('C', 100);
		ROMAN_SYMBOLS.put('D', 500);
		ROMAN_SYMBOLS.put('M', 1000);
	}

	public int romanToInt(String s) {
		char[] chArray = s.toCharArray();
		int number = 0;
		for (int i = 0; i < chArray.length; i++) {
			int val1 = ROMAN_SYMBOLS.get(chArray[i]);
			if (i < chArray.length - 1) {
				int val2 = ROMAN_SYMBOLS.get(chArray[i + 1]);
				if (val1 >= val2)
					number += val1;
				else if (val1 < val2) {
					number = number - val1 + val2;
					i++;
				}
			} else if (i == chArray.length - 1)
				number += val1;
		}
		return number;
	}
}
