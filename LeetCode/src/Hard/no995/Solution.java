package Hard.no995;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int minKBitFlips(int[] nums, int k) {

		int ans = 0;
		Queue<Integer> flipIndex = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {

			while (!flipIndex.isEmpty() && flipIndex.peek() <= i - k) {
				flipIndex.poll();
			}

			if (flipIndex.size() % 2 == nums[i]) {
				if (i + k > nums.length) {
					return -1;
				} else {
					flipIndex.add(i);
					ans++;
				}
			}

		}
		return ans;
	}
}
