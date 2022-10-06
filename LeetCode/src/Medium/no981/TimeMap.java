package Medium.no981;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TimeMap {

	HashMap<String, PriorityQueue<VO>> map;

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key))
			map.put(key, new PriorityQueue<>());

		map.get(key).add(new VO(value, timestamp));
	}

	public String get(String key, int timestamp) {

		String result = "";

		if (map.containsKey(key)) {

			HashSet<VO> bin = new HashSet<>();

			while (!map.get(key).isEmpty()) {

				VO temp = map.get(key).poll();
				bin.add(temp);

				if (temp.timestamp <= timestamp) {

					result = temp.value;
					break;
				}

			}

			map.get(key).addAll(bin);

		}

		return result;
	}
}

class VO implements Comparable<VO> {

	String value;
	int timestamp;

	VO(String value, int timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}

	@Override
	public int compareTo(VO o) {
		return o.timestamp - this.timestamp;
	}

}