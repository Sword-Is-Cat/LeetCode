package Easy.no977;

class Solution {
	public int[] sortedSquares(int[] nums) {

		int[] answer = new int[nums.length];

		int left = 0, right = nums.length - 1, idx = nums.length - 1;

		while (left <= right) {
			if (nums[left] * nums[left] < nums[right] * nums[right]) {
				answer[idx] = nums[right] * nums[right];
				right--;
			} else {
				answer[idx] = nums[left] * nums[left];
				left++;
			}
			idx--;
		}

		return answer;

	}
}