package Easy.no189;

class Solution {
	public void rotate(int[] nums, int k) {

		k %= nums.length;

		int[] arr = new int[k];

		for (int i = 1; i <= k; i++) {
			arr[k - i] = nums[nums.length - i];
		}

		for (int i = 1; i <= nums.length - k; i++) {
			nums[nums.length - i] = nums[nums.length - i - k];
		}

		for (int i = 0; i < k; i++) {
			nums[i] = arr[i];
		}

	}
}