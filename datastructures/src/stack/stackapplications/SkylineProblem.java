package stack.stackapplications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//UNSOLVED
//https://leetcode.com/explore/interview/card/microsoft/48/others/157/
public class SkylineProblem {

	private static class Building {
		private int st;
		private int end;
		private int ht;

		private Building(int st, int end, int ht) {
			this.st = st;
			this.end = end;
			this.ht = ht;
		}
	}

	static public List<List<Integer>> getSkyline(int[][] a) {
		int n = a.length;
		List<List<Integer>> result = new ArrayList<>();
		Stack<Building> s = new Stack<>();
		s.push(new Building(a[0][0], a[0][1], a[0][2]));
		for (int i = 1; i < n;) {
			List<Building> buildings = new ArrayList<>();
			while (a[i][0] < s.peek().st)
				buildings.add(s.pop());
			buildings.add(s.pop());
			Collections.reverse(buildings);
			while (!buildings.isEmpty()) {
				Building x = buildings.remove(0);
				if (x.end > a[i][0]) {
					if (x.ht > a[i][2]) {
						if (x.end < a[i][1]) {
							s.push(x);
							s.push(new Building(x.end, a[i][1], a[i][2]));
						}
					} else if (x.ht == a[i][2])
						s.push(new Building(x.st, Math.max(x.end, a[i][1]), x.ht));
					else {
						if (x.end < a[i][1]) {
							s.push(new Building(x.st, x.end, x.ht));
							s.push(new Building(x.end, a[i][1], a[i][2]));
						} else if (x.end == a[i][1])
							s.push(new Building(a[i][0], a[i][1], x.ht));
						else {
							s.push(new Building(x.st, a[i][0], x.ht));
							s.push(new Building(a[i][0], a[i][1], a[i][2]));
							s.push(new Building(a[i][1], x.end, x.ht));
						}
					}
				} else if (x.end <= a[i][0]) {
					if (x.ht == a[i][2])
						s.push(new Building(x.st, Math.max(x.end, a[i][1]), x.ht));
					else {
						s.push(x);
						if (a[i][2] > x.end)
							s.push(new Building(x.end, x.end, 0));
						s.push(new Building(a[i][0], a[i][1], a[i][2]));
					}
				}
			}
		}
		while (!s.isEmpty()) {
			Building b = s.pop();
			List<Integer> list = new ArrayList<>();
			list.add(b.st);
			list.add(b.ht);
			result.add(list);
		}
		Collections.reverse(result);
		result.add(Arrays.asList(a[n - 1][1], 0));
		return result;
	}

	public static void main(String[] args) {
		// int[][] buildings = { { 2, 15, 10 }, { 3, 8, 15 }, { 6, 10, 12 } };
		int[][] buildings = { { 2, 15, 10 }, { 20, 25, 14 } };
		System.out.println(getSkyline(buildings));
	}
}
