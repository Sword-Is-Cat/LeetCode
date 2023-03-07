package Hard.no2444;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public long countSubarrays(int[] nums, int minK, int maxK) {

		Queue<Integer> minQue = new LinkedList<>();
		Queue<Integer> maxQue = new LinkedList<>();

		long ans = 0L;
		int left = 0, right = 0, length = nums.length;

		while (left < length) {

			while (right < length && minK <= nums[right] && nums[right] <= maxK) {
				if (minK == nums[right])
					minQue.add(right);
				if (maxK == nums[right])
					maxQue.add(right);
				right++;
			}

			if (!minQue.isEmpty() && !maxQue.isEmpty()) {
				ans += right - Math.max(minQue.peek(), maxQue.peek());
				if (minQue.peek() == left)
					minQue.poll();
				if (maxQue.peek() == left)
					maxQue.poll();
				left++;
			} else {
				minQue.clear();
				maxQue.clear();
				right++;
				left = right;
			}

		}

		return ans;
	}
}