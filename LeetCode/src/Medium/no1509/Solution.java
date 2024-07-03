package Medium.no1509;

import java.util.Arrays;

class Solution {
	public int minDifference(int[] nums) {

		if (nums.length < 4)
			return 0;

		int[] min = getFourMins(nums);
		int[] max = getFourMaxs(nums);

		return Math.min(Math.min(max[3] - min[0], max[2] - min[1]), Math.min(max[1] - min[2], max[0] - min[3]));

	}

	private int[] getFourMins(int[] nums) {
		int[] min = new int[4];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int num : nums) {
			for (int i = 0; i < 4; i++) {
				if (min[i] >= num) {
					min[i] = i == 3 ? num : min[i + 1];
				} else {
					if (i != 0) {
						min[i - 1] = num;
					}
					break;
				}
			}
		}
		return min;
	}

	private int[] getFourMaxs(int[] nums) {
		int[] max = new int[4];
		Arrays.fill(max, Integer.MIN_VALUE);
		for (int num : nums) {
			for (int i = 0; i < 4; i++) {
				if (max[i] <= num) {
					max[i] = i == 3 ? num : max[i + 1];
				} else {
					if (i != 0) {
						max[i - 1] = num;
					}
					break;
				}
			}
		}
		return max;
	}

}