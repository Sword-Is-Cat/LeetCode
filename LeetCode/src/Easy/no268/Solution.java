package Easy.no268;

class Solution {
	public int missingNumber(int[] nums) {

		boolean[] arr = new boolean[nums.length + 1];

		for (int i : nums)
			arr[i] = true;

		int answer = 0;

		for (int i = 0; i < arr.length; i++)
			if (!arr[i]) {
				answer = i;
				break;
			}

		return answer;
	}
}