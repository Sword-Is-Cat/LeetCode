package Medium.no2684;

class Solution {
	public int maxMoves(int[][] grid) {

		boolean[][] flags = new boolean[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; row++) {
			flags[row][0] = true;
		}

		int answer = 0;

		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 0; row < grid.length; row++) {
				if (flags[row][col]) {
					answer = Math.max(answer, col);
					int nCol = col + 1;
					if (nCol < grid[0].length) {

						for (int nRow = row - 1; nRow <= row + 1; nRow++) {
							if (0 <= nRow && nRow < grid.length && grid[nRow][nCol] > grid[row][col]) {
								flags[nRow][nCol] = true;
							}
						}

					}
				}
			}
		}

		return answer;
	}
}