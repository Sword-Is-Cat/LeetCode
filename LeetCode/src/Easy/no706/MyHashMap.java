package Easy.no706;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

	List<Integer> keyList;
	List<Integer> valList;

	public MyHashMap() {
		keyList = new ArrayList<>();
		valList = new ArrayList<>();
	}

	public void put(int key, int value) {
		if (keyList.contains(key)) {
			valList.set(keyList.indexOf(key), value);
		} else {
			keyList.add(key);
			valList.add(value);
		}
	}

	public int get(int key) {
		int idx = keyList.indexOf(key);
		return idx == -1 ? -1 : valList.get(idx);
	}

	public void remove(int key) {
		int idx = keyList.indexOf(key);
		if (idx != -1) {
			key = keyList.remove(idx);
			key = valList.remove(idx);
		}
	}
}