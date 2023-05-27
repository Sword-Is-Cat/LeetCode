package Hard.no1406;

class Solution {
	public String stoneGameIII(int[] stoneValue) {

		int[] rSums = new int[stoneValue.length + 1];
		for (int i = stoneValue.length - 1; 0 <= i; i--) {
			rSums[i] = rSums[i + 1] + stoneValue[i];
		}

		int[] dp = new int[rSums.length];

		for (int i = dp.length - 1; 0 <= i; i--) {

			int value = 0;

			if (stoneValue.length <= i + 3) {
				value = rSums[i];
			} else {

				for (int len = 1; len <= 3; len++) {
					value = Math.max(value, rSums[i] - dp[i + len]);
				}
			}
			dp[i] = value;
		}

		int alice = dp[0], bob = rSums[0] - alice;

		return alice == bob ? "Tie" : alice > bob ? "Alice" : "Bob";
	}
}
