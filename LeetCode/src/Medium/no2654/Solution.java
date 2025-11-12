package Medium.no2654;

class Solution {
	public int minOperations(int[] nums) {

		int minAct = nums.length;
		int cntOne = 0;

		for (int i = 0; i < nums.length; i++) {
			int gcd = nums[i];
			if (gcd == 1)
				cntOne++;
			for (int act = 0; i + act < nums.length; act++) {
				gcd = gcd(gcd, nums[i + act]);
				if (gcd == 1) {
					minAct = Math.min(minAct, act);
					break;
				}
			}
		}
		if (cntOne == 0)
			cntOne = 1;

		return minAct == nums.length ? -1 : (minAct + nums.length - cntOne);
	}

	public int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}