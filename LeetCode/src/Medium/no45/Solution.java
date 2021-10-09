package Medium.no45;

class Solution {
	public int jump(int[] nums) {

		if (nums.length == 1)
			return 0;

		int cnt = 0;
		int expect = nums[0];
		int temp = expect;

		for (int i = 0; i < nums.length; i++) {

			if (expect >= nums.length - 1) {
				cnt++;
				break;
			}

			nums[i] += i;

			temp = Math.max(temp, nums[i]);
			if (i == expect) {
				cnt++;
				expect = temp;

			}

		}

		return cnt;
	}
}