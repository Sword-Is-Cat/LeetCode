package Medium.no264;

class Solution {
	public int nthUglyNumber(int n) {

		int[] dp = new int[n + 1];
		dp[1] = 1;

		for (int i = 2, i2 = 1, i3 = 1, i5 = 1; i <= n; i++) {

			int n2 = 2 * dp[i2], n3 = 3 * dp[i3], n5 = 5 * dp[i5];
			int min = Math.min(n2, Math.min(n3, n5));
			dp[i] = min;

			if (min == n2)
				i2++;
			if (min == n3)
				i3++;
			if (min == n5)
				i5++;

		}

		return dp[n];
	}
}