package Medium.no1760;

class Solution {
	public int minimumSize(int[] nums, int maxOperations) {

		int min = 0, max = Integer.MAX_VALUE / 2;

		while (min + 1 < max) {
			int mid = (min + max) / 2;
			if (operationForTargetPenalty(nums, mid) <= maxOperations)
				max = mid;
			else
				min = mid;
		}

		return max;
	}

	private int operationForTargetPenalty(int[] nums, int penalty) {
		int operation = 0;
		for (int num : nums) {
			operation += (num - 1) / penalty;
		}
		return operation;
	}
}