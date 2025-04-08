package Easy.no3396;

import java.util.Arrays;

class Solution {
	public int minimumOperations(int[] nums) {

		int[] lastIndex = new int[101];
		Arrays.fill(lastIndex, -1);
		int rmvIdx = -1;

		for (int i = 0; i < nums.length; i++) {
			rmvIdx = Math.max(rmvIdx, lastIndex[nums[i]]);
			lastIndex[nums[i]] = i;
		}

		return rmvIdx == -1 ? 0 : (rmvIdx / 3 + 1);
	}
}