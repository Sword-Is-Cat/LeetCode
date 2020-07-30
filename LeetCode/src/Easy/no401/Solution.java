package Easy.no401;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public List<String> readBinaryWatch(int num) {

		List<String> list = new ArrayList<>();
		Map<Integer, List<Integer>> hourMap = new HashMap<>();
		Map<Integer, List<Integer>> minMap = new HashMap<>();

		for (int i = 0; i < 12; i++) {
			int key = 0;
			int hour = i;
			while (hour > 0) {
				key += hour % 2;
				hour /= 2;
			}

			if (!hourMap.containsKey(key)) {
				List<Integer> temp = new ArrayList<>();
				hourMap.put(key, temp);
			}

			hourMap.get(key).add(i);
		}

		for (int i = 0; i < 60; i++) {
			int key = 0;
			int min = i;
			while (min > 0) {
				key += min % 2;
				min /= 2;
			}

			if (!minMap.containsKey(key)) {
				List<Integer> temp = new ArrayList<>();
				minMap.put(key, temp);
			}
			minMap.get(key).add(i);
		}

		for (int i = 0; i <= num; i++) {
			if (hourMap.containsKey(i) && minMap.containsKey(num - i)) {

				for (Integer hour : hourMap.get(i)) {
					for (Integer min : minMap.get(num - i)) {
						if (min < 10)
							list.add(hour + ":0" + min);
						else
							list.add(hour + ":" + min);
					}
				}
			}
		}

		return list;

	}
}