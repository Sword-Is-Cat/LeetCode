package Medium.no416;

class Solution {
	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum % 2 == 1)
			return false;

		int target = sum / 2;
		boolean[] occur = new boolean[target + 1];
		occur[0] = true;
		for (int num : nums) {
			for (int i = target; i >= num; i--) {
				if (occur[i - num])
					occur[i] = true;
			}
		}

		return occur[target];

	}
}