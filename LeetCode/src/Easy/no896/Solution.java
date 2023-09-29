package Easy.no896;

class Solution {
	public boolean isMonotonic(int[] nums) {

		int std = Integer.compare(nums[0], nums[nums.length - 1]);
		boolean flag = true;

		for (int i = 1; flag && i < nums.length; i++) {
			int comp = Integer.compare(nums[i - 1], nums[i]);
			flag &= comp == 0 || comp == std;
		}

		return flag;
	}
}