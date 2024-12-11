package Medium.no2779;

class Solution {
	public int maximumBeauty(int[] nums, int k) {

		int maxVal = nums[0];
		for (int num : nums) {
			maxVal = Math.max(maxVal, num);
		}

		int[] count = new int[maxVal + 1];
		for (int num : nums) {
			count[Math.max(num - k, 0)]++;
			count[Math.min(num + k + 1, maxVal)]--;
		}

		int sum = 0, answer = 1;
		for (int cnt : count) {
			sum += cnt;
			answer = Math.max(answer, sum);
		}

		return answer;
	}
}