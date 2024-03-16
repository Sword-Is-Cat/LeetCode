package Medium.no525;

import java.util.HashMap;

class Solution {
	public int findMaxLength(int[] nums) {

		int count = 0;
		HashMap<Integer, int[]> map = new HashMap<>();

		map.put(0, new int[] { -1, -1 });

		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			if (map.containsKey(count)) {
				map.get(count)[1] = i;
			} else {
				map.put(count, new int[] { i, i });
			}
		}

		int answer = 0;

		for (int key : map.keySet()) {
			answer = Math.max(answer, map.get(key)[1] - map.get(key)[0]);
		}

		return answer;
	}
}