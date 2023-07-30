package Hard.no664;

class Solution {
	public int strangePrinter(String s) {

		char[] arr = s.toCharArray();
		int[][] dp = new int[arr.length][arr.length];

		for (int ed = 0; ed < arr.length; ed++) {
			dp[ed][ed] = 1;
			for (int st = ed - 1; 0 <= st; st--) {
				dp[st][ed] = 1 + dp[st + 1][ed];

				for (int md = ed; md > st; md--) {
					if (arr[md] == arr[st]) {
						dp[st][ed] = Math.min(dp[st][ed], dp[md][ed]+dp[st+1][md-1]);
					}
				}
			}
		}
		return dp[0][arr.length - 1];
	}
}