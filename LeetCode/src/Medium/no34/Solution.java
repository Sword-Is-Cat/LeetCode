package Medium.no34;

class Solution {
	public int[] searchRange(int[] nums, int target) {

		int[] answer = { -1, -1 };

		if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
			return answer;

		int minLeft = -1, minRight = nums.length, minMid = 0;

		while (minLeft < minRight - 1) {
			minMid = (minLeft + minRight) / 2;
			if (nums[minMid] < target)
				minLeft = minMid;
			else
				minRight = minMid;
		}

		int maxLeft = -1, maxRight = nums.length, maxMid = 0;
		while (maxLeft < maxRight - 1) {
			maxMid = (maxLeft + maxRight) / 2;
			if (nums[maxMid] > target)
				maxRight = maxMid;
			else
				maxLeft = maxMid;
		}

		if (minLeft != -1 && nums[minRight] > target)
			return answer;

		return new int[] { minRight, maxLeft };
	}
}