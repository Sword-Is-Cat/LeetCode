package Challenge.October1st_2;

import java.util.Arrays;

class Solution {
	public int findPairs(int[] nums, int k) {

		Arrays.sort(nums);

		if (nums.length < 2)
			return 0;

		int answer = 0;
		int temp = nums[0]+1;

		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] == temp)
				continue;

			temp = nums[i];

			for (int j = i + 1; j < nums.length; j++) {
				
				if (nums[i] + k > nums[j])
					continue;
				else if (nums[i] + k == nums[j]) {
					answer++;
					break;
				} else
					break;
			}
		}

		return answer;
	}
}