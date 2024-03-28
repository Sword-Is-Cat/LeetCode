package Medium.no2958;

import java.util.HashMap;

class Solution {
	public int maxSubarrayLength(int[] nums, int k) {

		int answer = 0;
		int left = 0, right = 0;
		HashMap<Integer, Integer> counter = new HashMap<>();

		while (right < nums.length) {

			int num = nums[right++];

			counter.put(num, counter.getOrDefault(num, 0) + 1);

			while (counter.get(num) > k) {
				counter.put(nums[left], counter.get(nums[left++]) - 1);
			}

			answer = Math.max(answer, right - left);

		}

		return answer;
	}
}