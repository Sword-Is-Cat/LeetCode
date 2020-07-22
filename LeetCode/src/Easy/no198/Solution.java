package Easy.no198;

class Solution {
	public int rob(int[] nums) {

		if (nums.length < 3) {

			int answer = 0;

			for (int i : nums)
				answer = answer > i ? answer : i;

			return answer;
		}

		int[] arr = new int[nums.length];

		arr[0] = nums[0];
		arr[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < arr.length; i++)
			arr[i] = arr[i - 2] + nums[i] > arr[i - 1] ? arr[i - 2] + nums[i] : arr[i - 1];

		return arr[arr.length - 1];

	}
}