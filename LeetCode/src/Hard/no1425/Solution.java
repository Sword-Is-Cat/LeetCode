package Hard.no1425;

import java.util.ArrayDeque;

public class Solution {
	public int constrainedSubsetSum(int[] nums, int k) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			nums[i] += !dq.isEmpty() ? nums[dq.peekFirst()] : 0;

			while (!dq.isEmpty() && (i - dq.peekFirst() >= k || nums[i] >= nums[dq.peekLast()])) {
				if (nums[i] >= nums[dq.peekLast()])
					dq.pollLast();
				else
					dq.pollFirst();
			}

			if (nums[i] > 0) {
				dq.offerLast(i);
			}
		}
		int ans = nums[0];
		for (int num : nums)
			ans = Math.max(ans, num);
		return ans;
	}
}