package Medium.no2294;

import java.util.Arrays;

class Solution {
	public int partitionArray(int[] nums, int k) {

		Arrays.sort(nums);
		int max = nums[0] - 1, answer = 0;
		for (int num : nums) {
			if (max < num) {
				answer++;
				max = num + k;
			}
		}

		return answer;
	}
}