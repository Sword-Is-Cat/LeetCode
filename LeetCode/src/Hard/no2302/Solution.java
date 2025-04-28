package Hard.no2302;

class Solution {
	public long countSubarrays(int[] nums, long k) {

		long answer = 0, sum = 0;
		int addIdx = 0, rmvIdx = 0;

		while (addIdx < nums.length) {
			sum += nums[addIdx++];
			while (rmvIdx < addIdx && sum * (addIdx - rmvIdx) >= k) {
				sum -= nums[rmvIdx++];
			}
			answer += addIdx - rmvIdx;
		}

		return answer;

	}
}