package Medium.no841;

import java.util.List;

class Solution {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		boolean[] haveKeys = new boolean[rooms.size()];
		process(rooms, haveKeys, 0);

		boolean result = true;

		for (int idx = 0; result && idx < haveKeys.length; idx++) {
			result &= haveKeys[idx];
		}

		return result;
	}

	void process(List<List<Integer>> rooms, boolean[] haveKeys, int keyNo) {

		if (!haveKeys[keyNo]) {
			haveKeys[keyNo] = true;
			for (int key : rooms.get(keyNo)) {
				process(rooms, haveKeys, key);
			}
		}
	}
}