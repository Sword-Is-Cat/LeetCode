package Hard.no862;

class Solution {
	public int shortestSubarray(int[] nums, int k) {

		int length = nums.length, ans = length + 1;

		long[] pSum = new long[length + 1];
		int[] idxQue = new int[length + 1];

		for (int i = 0; i < length; i++) {
			pSum[i + 1] = pSum[i] + nums[i];
		}

		for (int i = 0, l = 0, r = 0; i <= length; i++) {

			while (l < r && pSum[i] - pSum[idxQue[l]] >= k) {
				ans = Math.min(ans, i - idxQue[l++]);
			}

			while (l < r && pSum[i] <= pSum[idxQue[r - 1]]) {
				r--;
			}

			idxQue[r++] = i;
		}

		return ans > length ? -1 : ans;

	}
}