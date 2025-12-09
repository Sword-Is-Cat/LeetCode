package Medium.no3583;

import java.util.HashMap;

class Solution {
	public int specialTriplets(int[] nums) {
		int ans = 0, MOD = 1_000_000_007;
		// counter: 지금까지 출현한 수, pointer: 출현 시 획득하는 포인트 량
		HashMap<Integer, Integer> counter = new HashMap<>(), pointer = new HashMap<>();
		for (int num : nums) {
			int doub = num * 2;
			ans = (ans + pointer.getOrDefault(num, 0)) % MOD;
			pointer.put(doub, (pointer.getOrDefault(doub, 0) + counter.getOrDefault(doub, 0)) % MOD);
			counter.put(num, counter.getOrDefault(num, 0) + 1);
		}
		return ans;
	}
}