package Hard.no403;

import java.util.HashMap;

class Solution {

	int[] stones;
	HashMap<Integer, HashMap<Integer, Boolean>> cache;

	public boolean canCross(int[] stones) {

		this.stones = stones;
		this.cache = new HashMap<>();

		return canJump(1, 1);
	}

	private boolean canJump(int position, int step) {

		int index = indexOf(position);
		if (index == -1 || step < 1)
			return false;

		if (index + 1 == stones.length)
			return true;

		if (!cache.containsKey(position) || !cache.get(position).containsKey(step)) {

			boolean flag = false;

			if (!flag) {
				flag |= canJump(position + step, step);
			}

			if (!flag) {
				flag |= canJump(position + step - 1, step - 1);
			}

			if (!flag) {
				flag |= canJump(position + step + 1, step + 1);
			}

			cache.putIfAbsent(position, new HashMap<>());
			cache.get(position).put(step, flag);

		}
		return cache.get(position).get(step);
	}

	private int indexOf(int stone) {
		int left = 0, right = stones.length;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (stone < stones[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return stones[left] == stone ? left : -1;
	}
}