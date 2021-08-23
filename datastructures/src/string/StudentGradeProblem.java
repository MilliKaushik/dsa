package string;

import java.util.ArrayList;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/student-record1752/1#
public class StudentGradeProblem {

	public String getMaxAverage(String[][] data) {
		int maxAverage = 0;
		List<Integer> indexOfMax = new ArrayList<>();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			int marks1 = Integer.parseInt(data[i][1]);
			int marks2 = Integer.parseInt(data[i][2]);
			int marks3 = Integer.parseInt(data[i][3]);

			int average = (int) Math.floor((marks1 + marks2 + marks3) / 3);
			if (average > maxAverage) {
				maxAverage = average;
				indexOfMax.clear();
				indexOfMax.add(i);
			} else if (average == maxAverage)
				indexOfMax.add(i);
		}
		for (int j = 0; j < indexOfMax.size(); j++) {
			res.append(data[indexOfMax.get(j)][0]);
			res.append(" ");
		}
		res.append(maxAverage);
		return res.toString();
	}
}
