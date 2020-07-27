package Easy.no169;

import java.util.Arrays;

class Solution {
	public int majorityElement(int[] nums) {

		int length = nums.length;
		int answer = 0;

		Arrays.sort(nums);

		int no = Integer.MAX_VALUE;
		int count = 0;

		for (int i : nums) {
			if (i == no)
				count++;
			else {
				no = i;
				count = 1;
			}

			if (count > length / 2) {
				answer = i;
				break;
			}
		}

		return answer;

	}
}