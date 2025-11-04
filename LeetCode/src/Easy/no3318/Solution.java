package Easy.no3318;

import java.util.PriorityQueue;

class Solution {
	public int[] findXSum(int[] nums, int k, int x) {

		int max = 0;
		for (int num : nums)
			max = Math.max(num, max);

		int[] cnt = new int[max + 1];
		int[] ans = new int[nums.length - k + 1];
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
			int comp = b[1] - a[1];
			if (comp == 0)
				comp = b[0] - a[0];
			return comp;
		});

		for (int i = 0; i < nums.length; i++) {

			cnt[nums[i]]++;
			if (i >= k - 1) {
				ans[i - k + 1] = x_sum(queue, cnt, x);
				cnt[nums[i - k + 1]]--;
			}
		}

		return ans;

	}

	private int x_sum(PriorityQueue<int[]> queue, int[] cnt, int x) {
		int rst = 0;
		queue.clear();
		for (int i = 0; i < cnt.length; i++)
			queue.offer(new int[] { i, cnt[i] });
		while (x-- > 0 && !queue.isEmpty()) {
			int[] item = queue.poll();
			rst += item[0] * item[1];
		}
		return rst;
	}

}