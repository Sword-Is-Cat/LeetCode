package Medium.no380;

import java.util.ArrayList;
import java.util.HashSet;

class RandomizedSet_ {

	HashSet<Integer> set;
	ArrayList<Integer> list;

	public RandomizedSet_() {
		set = new HashSet<>();
	}

	public boolean insert(int val) {
		if (list != null)
			list = null;
		return set.add(val);
	}

	public boolean remove(int val) {
		if (list != null)
			list = null;
		return set.remove(val);
	}

	public int getRandom() {
		if (list == null)
			list = new ArrayList<>(set);

		return list.get((int) (Math.random() * set.size()));

	}
}