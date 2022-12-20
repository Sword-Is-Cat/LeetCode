package Medium.no841;

import java.util.List;

class Solution {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		// 키 획득여부를 담을 boolean배열 선언
		boolean[] keys = new boolean[rooms.size()];
		// 0번방 키는 기본 획득
		addKey(rooms, keys, 0);
		// 모든 방의 키 획득했는지 확인하여 return
		boolean result = true;
		for (int idx = 0; result && idx < keys.length; idx++) {
			result &= keys[idx];
		}
		return result;
	}

	// 키 획득 시 해당 방에서 획득하는 다른 키에 대해 재귀호출
	void addKey(List<List<Integer>> rooms, boolean[] keys, int keyNo) {
		// 이미 획득한 키에 대해서는 로직 진행하지 않음
		if (keys[keyNo])
			return;
		keys[keyNo] = true;
		for (int newKey : rooms.get(keyNo)) {
			addKey(rooms, keys, newKey);
		}
	}
}