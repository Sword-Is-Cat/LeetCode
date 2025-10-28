package Easy.no3354;

class Solution {
	public int countValidSelections(int[] nums) {
		int[] sumRight = new int[nums.length], sumLeft = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sumLeft[i] = nums[i] + (i == 0 ? 0 : sumLeft[i - 1]);
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			sumRight[i] = nums[i] + (i == nums.length - 1 ? 0 : sumRight[i + 1]);
		}
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int abs = Math.abs(sumRight[i] - sumLeft[i]);
				if (abs == 0)
					ans += 2;
				else if (abs == 1)
					ans += 1;
			}
		}
		return ans;
	}
}