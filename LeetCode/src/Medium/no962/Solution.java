package Medium.no962;

class Solution {
	public int maxWidthRamp(int[] nums) {

		int[] rightMax = new int[nums.length + 1];
		for (int i = nums.length - 1; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
		}

		int answer = 0;
		for (int left = 0, right = 0; right < nums.length; right++) {
			while (nums[left] > rightMax[right]) {
				left++;
			}
			answer = Math.max(answer, right - left);
		}

		return answer;
	}
}