package Medium.no611;

import java.util.Arrays;

class Solution {
	public int triangleNumber(int[] nums) {

		int[] cnt = new int[1001];
		for (int num : nums) {
			cnt[num]++;
		}
		for (int i = 1; i <= 1000; i++) {
			cnt[i] += cnt[i - 1];
		}
		System.out.println(Arrays.toString(cnt));

		Arrays.sort(nums);
		int answer = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				continue;
			for (int j = i + 1; j < nums.length; j++) {
				int item = Math.max(cnt[Math.min(1000, nums[i] + nums[j] - 1)] - j - 1, 0);
				answer += item;
			}
		}

		return answer;
	}
}