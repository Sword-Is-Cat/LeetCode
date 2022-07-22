package Medium.no80;

class Solution {
	public int removeDuplicates(int[] nums) {

		int temp = Integer.MAX_VALUE;
		int cnt = 0;
		int idx = 0;

		for (int i = 0; i < nums.length; i++) {

			if (temp != nums[i]) {
				temp = nums[i];
				cnt = 1;
				nums[idx++] = nums[i];
			} else {
				if (++cnt < 3) {
					nums[idx++] = nums[i];
				}
			}

		}
		return idx;
	}
}