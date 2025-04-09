package Easy.no3375;

import java.util.Arrays;

class Solution {
	public int minOperations(int[] nums, int k) {

		Arrays.sort(nums);
		if (nums[0] < k)
			return -1;

		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (k != nums[i]) {
				answer++;
				k = nums[i];
			}
		}
		return answer;
	}
}