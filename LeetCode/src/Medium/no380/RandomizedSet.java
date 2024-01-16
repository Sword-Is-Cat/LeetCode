package Medium.no380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

	private final Map<Integer, Integer> index = new HashMap<>();
	private final List<Integer> list = new ArrayList<>();
	private final Random random = new Random();

	public RandomizedSet() {

	}

	public boolean insert(int val) {

		if (index.containsKey(val))
			return false;

		index.put(val, list.size());
		list.add(val);

		return true;
	}

	public boolean remove(int val) {

		if (!index.containsKey(val))
			return false;

		int idx = index.get(val), size = list.size(), lastVal = list.get(size - 1);
		
		if (idx != size - 1) {
			list.set(idx, lastVal);
			index.put(lastVal, idx);
		}

		index.remove(val, idx);
		list.remove(size - 1);

		return true;
	}

	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
}