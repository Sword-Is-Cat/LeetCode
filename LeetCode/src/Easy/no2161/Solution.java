package Easy.no2161;

class Solution {
	public int[] pivotArray(int[] nums, int pivot) {

		int[] answer = new int[nums.length];

		int idx = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < pivot) {
				answer[idx++] = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == pivot) {
				answer[idx++] = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > pivot) {
				answer[idx++] = nums[i];
			}
		}

		return answer;
	}
}