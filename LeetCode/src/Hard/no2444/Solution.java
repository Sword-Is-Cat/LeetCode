package Hard.no2444;

class Solution {
	public long countSubarrays(int[] nums, int minK, int maxK) {

		long ans = 0L;
		int badIdx = -1, minIdx = -1, maxIdx = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < minK || maxK < nums[i]) {
				badIdx = i;
			}
			if (nums[i] == minK) {
				minIdx = i;
			}
			if (nums[i] == maxK) {
				maxIdx = i;
			}
			ans += Math.max(0, Math.min(minIdx, maxIdx) - badIdx);
		}

		return ans;
	}
}