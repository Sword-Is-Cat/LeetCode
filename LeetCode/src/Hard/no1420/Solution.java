package Hard.no1420;

class Solution {

	static final int MOD = (int) 1e9 + 7;

	public int numOfArrays(int n, int m, int k) {

		int[][][] dp = new int[n][m + 1][k + 1];

		for (int i = 1; i <= m; i++) {
			dp[0][i][1] = 1;
		}

		for (int index = 1; index < dp.length; index++) {
			for (int maxValue = 1; maxValue < dp[index].length; maxValue++) {
				for (int cost = 1; cost < dp[index][maxValue].length; cost++) {
					int value = 0;
					for (int prevValue = 1; prevValue < maxValue; prevValue++) {
						// 갱신
						value = (value + dp[index - 1][prevValue][cost - 1]) % MOD;
						// 비갱신
						value = (value + dp[index - 1][maxValue][cost]) % MOD;
					}
					value = (value + dp[index - 1][maxValue][cost]) % MOD;
					dp[index][maxValue][cost] = value;
				}
			}
		}

		int ans = 0;
		for (int value = 1; value <= m; value++) {
			ans = (ans + dp[n - 1][value][k]) % MOD;
		}
		return ans;
	}
}