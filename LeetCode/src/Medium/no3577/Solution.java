package Medium.no3577;

class Solution {
	public int countPermutations(int[] complexity) {
		long ans = 1;
		int MOD = 1_000_000_007;
		for (int i = 1; i < complexity.length; i++) {
			if (complexity[i] <= complexity[0])
				return 0;
			ans = (ans * i) % MOD;
		}
		return (int) ans;
	}
}