package Easy.no665;

class Solution {
	public boolean checkPossibility(int[] nums) {

		boolean check = false;

		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] > nums[i + 1]) {

				if (check)
					return false;
				else
					check = true;

				if (i > 0 && nums[i - 1] > nums[i + 1])
					nums[i + 1] = nums[i];
			}
		}

		return true;
	}
}