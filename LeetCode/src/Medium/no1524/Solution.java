package Medium.no1524;

class Solution {

	final int MOD = (int) 1e9 + 7;

	public int numOfSubarrays(int[] arr) {

		int[] counter = { 1, 0 };
		int sum = 0, ans = 0;

		for (int num : arr) {
			sum = (sum + num) % 2;
			ans = (ans + counter[1 ^ sum]) % MOD;
			counter[sum]++;
		}

		return ans;
	}
}