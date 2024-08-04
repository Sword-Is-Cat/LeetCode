package Medium.no1508;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int rangeSum(int[] nums, int n, int left, int right) {

		final int MOD = (int) 1e9 + 7;

		// {nextIndex, sum}
		Queue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		for (int i = 0; i < n; i++) {
			que.add(new int[] { i + 1, nums[i] });
		}

		int idx = 0, ans = 0;
		while (idx++ < right) {

			int[] item = que.poll();
			if (left <= idx) {
				ans = (ans + item[1]) % MOD;
			}
			if (item[0] < n) {
				item[1] += nums[item[0]];
				item[0]++;
				que.add(item);
			}

		}

		return ans;
	}
}
