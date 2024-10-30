package Hard.no1671;

class Solution {
	public int minimumMountainRemovals(int[] nums) {

		int[] leftM = new int[nums.length], rightM = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			leftM[i] = i;
			for (int left = 0; left < i; left++) {
				if (nums[left] < nums[i]) {
					leftM[i] = Math.min(leftM[i], leftM[left] + i - left - 1);
				}
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			rightM[i] = nums.length - i - 1;
			for (int right = nums.length - 1; right > i; right--) {
				if (nums[i] > nums[right]) {
					rightM[i] = Math.min(rightM[i], rightM[right] + right - i - 1);
				}
			}
		}

		int answer = 1000;

		for (int i = 0; i < nums.length; i++) {
			if (leftM[i] != i && rightM[i] != nums.length - i - 1)
				answer = Math.min(answer, leftM[i] + rightM[i]);
		}

		return answer;
	}
}