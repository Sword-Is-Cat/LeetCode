package Medium.no1248;

import java.util.ArrayDeque;

class Solution {
	public int numberOfSubarrays(int[] nums, int k) {

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int temp = 1, ans = 0;

		for (int num : nums) {
			if (num % 2 == 0) {
				temp++;
			} else {
				if (queue.size() == k) {
					ans += temp * queue.poll();
				}
				queue.add(temp);
				temp = 1;
			}
		}
		if (queue.size() == k) {
			ans += temp * queue.poll();
		}

		return ans;
	}
}