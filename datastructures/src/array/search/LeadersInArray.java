package array.search;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/leaders-in-an-array/
public class LeadersInArray {

	public ArrayList<Integer> getLeaders(int[] num) {
		int n = num.length;
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		int max = num[n - 1];
		leaders.add(max);

		for (int i = n - 2; i >= 0; i--) {
			if (num[i] >= max) {
				leaders.add(num[i]);
				max = num[i];
			}
		}
		ArrayList<Integer> l = new ArrayList<>();
		for (int i = leaders.size() - 1; i >= 0; i--)
			l.add(leaders.get(i));
		return l;
	}
}
