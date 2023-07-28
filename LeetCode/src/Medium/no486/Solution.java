package Medium.no486;

class Solution {

	int[] nums;
	int[][] cache;
	boolean[][] visit;

	public boolean PredictTheWinner(int[] nums) {

		this.nums = nums;
		this.cache = new int[nums.length][nums.length];
		this.visit = new boolean[nums.length][nums.length];

		return expectPoint(0, nums.length - 1) >= 0;
	}

	private int expectPoint(int left, int right) {

		if (!visit[left][right]) {
			visit[left][right] = true;
			cache[left][right] = nums[left];

			if (left < right) {
				int choiceL = nums[left] - expectPoint(left + 1, right);
				int choiceR = nums[right] - expectPoint(left, right - 1);
				cache[left][right] = Math.max(choiceL, choiceR);
			}
		}

		return cache[left][right];
	}

}