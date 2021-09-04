package Medium.no34;

class Solution {
	public int[] searchRange(int[] nums, int target) {

		int[] answer = { -1, -1 };

		if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
			return answer;

		int minLeft = -1;
		int minRight = nums.length;
		int minMid = 0;

		int maxLeft = -1;
		int maxRight = nums.length;
		int maxMid = 0;

		while (minLeft < minRight - 1) {

			minMid = (minLeft + minRight) / 2;

			if (nums[minMid] < target)
				minLeft = minMid;
			else
				minRight = minMid;

		}

		while (maxLeft < maxRight - 1) {

			maxMid = (maxLeft + maxRight) / 2;

			if (nums[maxMid] > target)
				maxRight = maxMid;
			else
				maxLeft = maxMid;

		}

		if (minLeft != -1 && nums[minRight] > target)
			return answer;

		answer[0] = minRight;
		answer[1] = maxLeft;

		return answer;
	}
}