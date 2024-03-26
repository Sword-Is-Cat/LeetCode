package Hard.no41;

class Solution {
	public int firstMissingPositive(int[] nums) {
		boolean[] visit = new boolean[nums.length + 1];
		for (int num : nums) {
			if (0 < num && num < visit.length) {
				visit[num] = true;
			}
		}
		for (int i = 1; i <= nums.length; i++) {
			if (!visit[i]) {
				return i;
			}
		}
		return visit.length;
	}
}