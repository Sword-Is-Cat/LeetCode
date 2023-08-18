package Medium.no1615;

class Solution {
	public int maximalNetworkRank(int n, int[][] roads) {

		int[] cnts = new int[n];
		boolean[][] connect = new boolean[n][n];

		for (int[] road : roads) {
			int a = road[0], b = road[1];
			cnts[a]++;
			cnts[b]++;
			connect[a][b] = true;
			connect[b][a] = true;
		}

		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int rank = cnts[i] + cnts[j] - (connect[i][j] ? 1 : 0);
				ans = Math.max(ans, rank);
			}
		}
		return ans;
	}
}