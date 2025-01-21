package Medium.no2017;

class Solution {
	public long gridGame(int[][] grid) {

		long upper = 0L, lower = 0L, ans = 0L;
		for (int i = 0; i < grid[0].length; i++) {
			upper += grid[0][i];
		}

		ans = upper;

		for (int i = 0; i < grid[0].length; i++) {
			upper -= grid[0][i];
			if (i > 0)
				lower += grid[1][i - 1];
			ans = Math.min(ans, Math.max(upper, lower));
		}

		return ans;
	}
}