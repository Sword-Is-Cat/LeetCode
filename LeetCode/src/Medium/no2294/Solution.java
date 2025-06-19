package Medium.no2294;

class Solution {
	public int partitionArray(int[] nums, int k) {

		boolean[] flags = new boolean[100001];
		int min = nums[0], max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			flags[num] = true;
		}
		int answer = 0;

		for (int i = min; i <= max; i++) {
			if (flags[i]) {
				answer++;
				i += k;
			}
		}

		return answer;
	}
}