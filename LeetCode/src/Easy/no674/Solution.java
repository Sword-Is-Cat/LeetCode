package Easy.no674;

class Solution {
	public int findLengthOfLCIS(int[] nums) {

		if (nums.length < 2)
			return 1;

		int max = 1;
		int length = 1;

		for (int i = 1; i < nums.length; i++) {
			
			if(nums[i]-nums[i-1] > 0)
				max = Math.max(max, ++length);
			else
				length = 1;
		}

		return max;

	}
}