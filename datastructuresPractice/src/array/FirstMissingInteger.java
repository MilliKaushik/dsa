package array;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/first-missing-integer/
public class FirstMissingInteger {

	public int firstMissingPositive(ArrayList<Integer> A) {
		ArrayList<Integer> arr = A;
		for (int i = 0; i < arr.size(); i++) {
			int index = arr.get(i);
			if (!(index >= 1) || !(index < arr.size()))
				continue;
			int indexElement = arr.get(index);
			if (indexElement > 0)
				indexElement *= -1;
		}

		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) > 0)
				return i;
		}
		return arr.size() + 1;
	}

}
