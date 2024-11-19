package Medium.no2461;

class Solution {
	public long maximumSubarraySum(int[] nums, int k) {

		int[] count = new int[100001];
		long sum = 0, answer = 0;

		for (int left = 0, right = 0; right < nums.length; right++) {

			count[nums[right]]++;
			sum += nums[right];

			while (right - left >= k || count[nums[right]] > 1) {
				count[nums[left]]--;
				sum -= nums[left++];
			}

			if (right - left + 1 == k) {
				answer = Math.max(answer, sum);
			}

		}

		return answer;
	}
}