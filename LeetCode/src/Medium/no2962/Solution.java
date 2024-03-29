package Medium.no2962;

class Solution {
	public long countSubarrays(int[] nums, int k) {

		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}

		int left = 0, right = 0;
		int cnt = 0;
		long answer = 0L;

		while (left < nums.length) {

			while (cnt < k && right < nums.length) {
				if (nums[right++] == max) {
					cnt++;
				}
			}

			if (cnt == k) {
				answer += nums.length - right + 1;
			}

			if (nums[left++] == max) {
				cnt--;
			}

		}

		return answer;
	}
}