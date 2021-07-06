package array.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//https://leetcode.com/problems/largest-number/
//https://www.interviewbit.com/problems/largest-number/	
public class LargestNumber {

	private class NumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			String ab = a + b;
			String ba = b + a;
			return ab.compareTo(ba);
		}
	}

	public String largestNumber(int[] A) {
		List<String> strArray = new ArrayList<>();
		int countOfZero = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0)
				countOfZero++;
			strArray.add(String.valueOf(A[i]));
		}
		if (countOfZero == A.length)
			return String.valueOf(0);
		Collections.sort(strArray, Collections.reverseOrder(new NumberComparator()));
		Iterator<String> it = strArray.iterator();
		StringBuilder str = new StringBuilder();
		while (it.hasNext())
			str.append(it.next());
		return str.toString();
	}
}
