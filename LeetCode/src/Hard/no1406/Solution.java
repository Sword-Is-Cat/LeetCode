package Hard.no1406;

class Solution {
	public String stoneGameIII(int[] stoneValue) {

		int[] rSums = new int[stoneValue.length + 1];
		for (int i = stoneValue.length - 1; 0 <= i; i--) {
			rSums[i] = rSums[i + 1] + stoneValue[i];
		}

		int[] dp = new int[rSums.length];

		for (int i = dp.length - 1; 0 <= i; i--) {

			int value = Integer.MIN_VALUE;

			for (int len = 1; len <= 3; len++) {
				if (i + len < dp.length)
					value = Math.max(value, rSums[i] - dp[i + len]);
				else
					value = Math.max(value, rSums[i]);
			}
			dp[i] = value;
		}

		int alice = dp[0], bob = rSums[0] - alice;

		return alice == bob ? "Tie" : alice > bob ? "Alice" : "Bob";
	}
}
