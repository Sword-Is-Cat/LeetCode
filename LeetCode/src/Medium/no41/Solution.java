package Medium.no41;

class Solution {
	public int firstMissingPositive(int[] nums) {

		boolean[] visit = new boolean[nums.length + 1];

		for (int num : nums) {
			if (0 < num && num < visit.length) {
				visit[num] = true;
			}
		}

		for (int idx = 1; idx < visit.length; idx++) {
			if (!visit[idx])
				return idx;
		}
		return visit.length;

	}
}