package Medium.no1438;

import java.util.ArrayDeque;

class Solution {
	public int longestSubarray(int[] nums, int limit) {

		ArrayDeque<Integer> ascending = new ArrayDeque<>();
		ArrayDeque<Integer> descending = new ArrayDeque<>();

		int ans = 0, rmvIdx = 0;

		for (int i = 0; i < nums.length; i++) {

			int num = nums[i];

			while (!ascending.isEmpty() && ascending.peekLast() > num) {
				ascending.pollLast();
			}
			ascending.addLast(num);

			while (!descending.isEmpty() && descending.peekLast() < num) {
				descending.pollLast();
			}
			descending.addLast(num);

			while (descending.peekFirst() - ascending.peekFirst() > limit) {
				if (nums[rmvIdx] == descending.peekFirst()) {
					descending.pollFirst();
				}
				if (nums[rmvIdx] == ascending.peekFirst()) {
					ascending.pollFirst();
				}
				rmvIdx++;
			}

			ans = Math.max(ans, i - rmvIdx);

		}

		return ans + 1;

	}
}