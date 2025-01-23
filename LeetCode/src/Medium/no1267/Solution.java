package Medium.no1267;

class Solution {
	public int countServers(int[][] grid) {

		int[] rowSum = new int[grid.length], colSum = new int[grid[0].length];
		int total = 0, isolate = 0;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					rowSum[r]++;
					colSum[c]++;
					total++;
				}
			}
		}

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (rowSum[r] == 1 && colSum[c] == 1 && grid[r][c] == 1)
					isolate++;
			}
		}

		return total - isolate;
	}
}