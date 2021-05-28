package array.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://www.interviewbit.com/problems/distinct-numbers-in-window/
public class DistinctNumbersinWindow {

	private static class Element {
		private int index;
		private int count;

		public Element(int index, int count) {
			this.index = index;
			this.count = count;
		}
	}

	public static ArrayList<Integer> dNums(List<Integer> arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (k > arr.size())
			return result;
		List<Integer> list = new LinkedList<>();
		Map<Integer, Element> map = new HashMap<>();
		int i = 0, j = 0;
		while (i < arr.size()) {
			Element ele = map.get(arr.get(i));
			if (ele != null)
				map.put(arr.get(i), new Element(i, ele.count + 1));
			else
				map.put(arr.get(i), new Element(i, 1));
			list.add(arr.get(i));
			if (i - j + 1 == k) {
				while (!list.isEmpty() && map.get(list.get(0)).index < j) {
					Element element = map.get(list.get(0));
					if (element.count == 1)
						map.remove(list.get(0));
					else
						map.put(list.get(0), new Element(element.index, element.count - 1));
					list.remove(0);
				}
				if (list.isEmpty())
					result.add(0);
				else {
					int p = 0;
					int distinct = 0;
					while (p < list.size() && map.get(list.get(p)).count == 1) {
						p++;
						distinct++;
					}
					result.add(distinct);
				}
				j++;
			}
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(dNums(Arrays.asList(1), 1));
		System.out.println(dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3));
		System.out.println(dNums(Arrays.asList(1, 1, 2, 2), 1));
	}
}
