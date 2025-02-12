package Medium.no2342;

class Solution {
	public int maximumSum(int[] nums) {

		int[] cache = new int[82];
		int answer = -1;

		for (int num : nums) {
			int dSum = digitSum(num);
			if (cache[dSum] > 0) {
				answer = Math.max(answer, cache[dSum] + num);
			}
			cache[dSum] = Math.max(cache[dSum], num);
		}

		return answer;
	}

	private int digitSum(int num) {
		int result = 0;
		while (num > 0) {
			result += num % 10;
			num /= 10;
		}
		return result;
	}
}