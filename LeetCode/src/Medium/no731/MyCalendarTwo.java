package Medium.no731;

import java.util.TreeMap;

class MyCalendarTwo {

	TreeMap<Integer, Integer> map;

	public MyCalendarTwo() {
		map = new TreeMap<>();
	}

	public boolean book(int start, int end) {

		map.put(start, map.getOrDefault(start, 0) + 1);
		map.put(end, map.getOrDefault(end, 0) - 1);

		int stack = 0;

		for (int key : map.navigableKeySet()) {
			stack += map.get(key);
			if (stack > 2) {
				map.compute(start, (k, v) -> v - 1);
				map.compute(end, (k, v) -> v + 1);
				return false;
			}
		}

		return true;
	}

}