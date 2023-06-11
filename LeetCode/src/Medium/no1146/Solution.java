package Medium.no1146;

import java.util.Map.Entry;
import java.util.TreeMap;

class SnapshotArray {

	TreeMap<Integer, Integer>[] logs;
	int snap_id = 0;

	public SnapshotArray(int length) {
		logs = new TreeMap[length];
		for (int i = 0; i < logs.length; i++)
			logs[i] = new TreeMap<>();
	}

	public void set(int index, int val) {
		logs[index].put(snap_id, val);
	}

	public int snap() {
		return snap_id++;
	}

	public int get(int index, int snap_id) {
		Entry<Integer, Integer> entry = logs[index].floorEntry(snap_id);
		return entry == null ? 0 : entry.getValue();
	}
}