package Medium.no75;

class Solution {
	public void sortColors(int[] nums) {

		int[] cnt = new int[3];

		for (int num : nums)
			cnt[num]++;

		int idx = 0;

		for (int no = 0; no < 3; no++) {
			while (cnt[no]-- > 0)
				nums[idx++] = no;
		}
	}
}