package Easy.no705;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyHashSet_ {

	List<Integer> list;

	public MyHashSet_() {
		list = new ArrayList<>();

	}

	public void add(int key) {

		if (!contains(key))
			list.add(key);

		Collections.sort(list);

	}

	public void remove(int key) {

		int index = getIndex(key);
		if (index != -1)
			list.remove(index);

	}

	public boolean contains(int key) {

		return getIndex(key) == -1 ? false : true;
	}

	public int getIndex(int key) {

		if (list.size() != 0) {
			int head = -1;
			int tail = list.size();

			int mid = -1;
			while (tail - head > 1) {
				mid = (head + tail) / 2;

				int no = list.get(mid);

				if (key < no)
					tail = mid;
				else if (no < key)
					head = mid;
				else if (no == key)
					return mid;
			}
		}
		return -1;

	}
}