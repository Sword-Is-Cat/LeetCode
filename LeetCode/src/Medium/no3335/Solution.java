package Medium.no3335;

class Solution {

	private final static int MOD = 1_000_000_007;

	public int lengthAfterTransformations(String s, int t) {

		int[] cache = new int[t + 26];
		for (int i = 0; i < cache.length; i++) {
			if (i < 26) {
				cache[i] = 1;
			} else {
				cache[i] = (cache[i - 26] + cache[i - 25]) % MOD;
			}
		}

		int answer = 0;
		for (char ch : s.toCharArray()) {
			answer = (answer + cache[ch - 'a' + t]) % MOD;
		}

		return answer;

	}
}