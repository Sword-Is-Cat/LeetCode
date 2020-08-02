package Easy.no506;

import java.util.Arrays;

class Solution {
	public String[] findRelativeRanks(int[] nums) {

		int[] ranked = nums.clone();
		Arrays.sort(ranked);

		String[] answer = new String[nums.length];

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (ranked[ranked.length - i] == nums[j]) {
					if (i == 1)
						answer[j] = "Gold Medal";
					else if (i == 2)
						answer[j] = "Silver Medal";
					else if (i == 3)
						answer[j] = "Bronze Medal";
					else
						answer[j] = i + "";
				}
			}
		}

		return answer;
	}
}