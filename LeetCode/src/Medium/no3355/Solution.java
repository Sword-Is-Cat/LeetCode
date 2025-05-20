package Medium.no3355;

class Solution {
	public boolean isZeroArray(int[] nums, int[][] queries) {

		int[] accumQuery = new int[nums.length + 1];
		for (int[] query : queries) {
			accumQuery[query[0]]++;
			accumQuery[query[1] + 1]--;
		}

		int accum = 0;
		for (int i = 0; i < nums.length; i++) {
			accum += accumQuery[i];
			if (nums[i] > accum)
				return false;
		}

		return true;
	}
}