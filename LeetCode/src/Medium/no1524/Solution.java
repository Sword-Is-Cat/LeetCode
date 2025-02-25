package Medium.no1524;

class Solution {

	final int MOD = (int) 1e9 + 7;

	public int numOfSubarrays(int[] arr) {

		int[] counter = { 1, 0 };
		int mask = 0, ans = 0;

		for (int num : arr) {
			mask = (mask ^ num) & 1;
			ans = (ans + counter[1 ^ mask]) % MOD;
			counter[mask]++;
		}

		return ans;
	}
}