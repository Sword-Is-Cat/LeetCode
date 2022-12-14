package Medium.no198;

public class Solution {

	public int rob(int[] nums) {

		switch (nums.length) {
		case 0:
			return 0;
		case 1:
			return nums[0];
		case 2:
			return Math.max(nums[0], nums[1]);
		case 3:
			return Math.max(nums[0] + nums[2], nums[1]);
		}

		nums[2] += nums[0];

		for (int idx = 3; idx < nums.length; idx++)
			nums[idx] += Math.max(nums[idx - 3], nums[idx - 2]);

		return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
	}
}
