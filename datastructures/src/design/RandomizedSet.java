package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/112/design/813/
public class RandomizedSet {
	private static final int CONST = 1;
	private Map<Integer, Integer> set;
	Random random = new Random();

	public RandomizedSet() {
		set = new HashMap<>();
	}

	public boolean insert(int val) {
		if (set.containsKey(val))
			return false;
		else {
			set.put(val, CONST);
			return true;
		}
	}

	public boolean remove(int val) {
		if (set.containsKey(val)) {
			set.remove(val);
			return true;
		} else
			return false;
	}

	public int getRandom() {
		List<Integer> list = new ArrayList<>(set.keySet());
		int i = random.nextInt(set.size());
		return list.get(i);
	}
}
