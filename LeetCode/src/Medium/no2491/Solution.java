package Medium.no2491;

class Solution {
	public long dividePlayers(int[] skill) {

		int[] freq = new int[1001];
		int min = 1000, max = 1;

		for (int num : skill) {
			freq[num]++;
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		int sum = min + max;

		long ans = 0L;

		for (int i = min; i <= max; i++) {
			if (freq[i] != freq[sum - i])
				return -1L;
			ans += 1L * i * (sum - i) * freq[i];
		}

		return ans / 2;

	}
}