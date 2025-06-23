package Hard.no2081;

class Solution {

	int[] nums = { 1, 1 };
	int idx = 0;

	public long kMirror(int k, int n) {

		long answer = 0;
		while (n > 0) {
			long num = nextNum();
			if (isMirror(num, k)) {
				n--;
				answer += num;
			}
		}

		return answer;

	}

	private long nextNum() {
		long num, prefix, suffix = 0;
		num = prefix = nums[idx]++;
		if (idx == 0)
			prefix /= 10;

		int check = nums[idx];
		while (check % 10 == 0)
			check /= 10;

		if (check == 1)
			idx ^= 1;

		while (num > 0) {
			prefix *= 10;
			suffix *= 10;
			suffix += num % 10;
			num /= 10;
		}

		return prefix + suffix;
	}

	private boolean isMirror(long num, int mod) {
		long temp = num, result = 0;
		while (temp > 0) {
			result *= mod;
			result += temp % mod;
			temp /= mod;
		}
		return num == result;
	}

}