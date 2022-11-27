package Medium.no213;

class Solution {
	public int rob(int[] nums) {

		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		int[] accum;
		int rst1, rst2;

		// [1] 첫집을 터는경우: 마지막집을 털지 못하므로 그 전 집까지만 확인
		accum = new int[nums.length - 1];

		for (int i = 0; i < accum.length; i++) {

			if (i < 2) {
				accum[i] = nums[i];
			} else if (i == 2) {
				accum[i] = nums[i] + accum[0];
			} else {
				accum[i] = nums[i] + Math.max(accum[i - 2], accum[i - 3]);
			}

		}

		rst1 = Math.max(accum[accum.length - 1], accum[accum.length - 2]);

		// [2] 첫집을 털지 않는 경우: 마지막집 까지 확인한다
		accum = new int[nums.length - 1];

		for (int i = 0; i < accum.length; i++) {

			if (i < 2) {
				accum[i] = nums[i + 1];
			} else if (i == 2) {
				accum[i] = nums[i + 1] + accum[0];
			} else {
				accum[i] = nums[i + 1] + Math.max(accum[i - 2], accum[i - 3]);
			}

		}

		rst2 = Math.max(accum[accum.length - 1], accum[accum.length - 2]);

		return Math.max(rst1, rst2);
	}
}