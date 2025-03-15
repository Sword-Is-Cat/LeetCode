package Medium.no2560;

class Solution {
	public int minCapability(int[] nums, int k) {

		int min = nums[0], max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		min--;
		max++;

		while (max - min > 1) {
			int mid = (max + min) / 2;
			if (possibleToRob(nums, mid, k)) {
				max = mid;
			} else {
				min = mid;
			}
		}

		return max;
	}

	private boolean possibleToRob(int[] nums, int cap, int k) {
		int count = 0, idx = 0;
		while (idx < nums.length) {
			if (nums[idx] <= cap) {
				count++;
				idx++;
			}
			idx++;
		}
		return count >= k;
	}
}