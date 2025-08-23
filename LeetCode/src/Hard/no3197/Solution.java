package Hard.no3197;

class Solution {
	public int minimumSum(int[][] grid) {
		return Math.min(process(grid), process(rotateGrid(grid)));
	}

	private int process(int[][] grid) {

		int rowLength = grid.length, colLength = grid[0].length;
		int result = rowLength * colLength;

		for (int r = 0; r < rowLength; r++) {
			for (int c = 0; c < colLength; c++) {
				result = Math.min(result, minimumArea(grid, 0, r, 0, c) + minimumArea(grid, 0, r, c, colLength)
						+ minimumArea(grid, r, rowLength, 0, colLength));
				result = Math.min(result, minimumArea(grid, 0, r, 0, colLength) + minimumArea(grid, r, rowLength, 0, c)
						+ minimumArea(grid, r, rowLength, c, colLength));
			}
		}

		for (int r1 = 0; r1 < rowLength; r1++) {
			for (int r2 = r1; r2 < rowLength; r2++) {
				result = Math.min(result, minimumArea(grid, 0, r1, 0, colLength)
						+ minimumArea(grid, r1, r2, 0, colLength) + minimumArea(grid, r2, rowLength, 0, colLength));
			}
		}

		return result;
	}

	private int minimumArea(int[][] grid, int rs, int re, int cs, int ce) {
		int maxR = -1, minR = grid.length, maxC = -1, minC = grid[0].length;
		for (int r = rs; r < re; r++) {
			for (int c = cs; c < ce; c++) {
				if (grid[r][c] == 1) {
					maxR = Math.max(maxR, r);
					minR = Math.min(minR, r);
					maxC = Math.max(maxC, c);
					minC = Math.min(minC, c);
				}
			}
		}
		return minR <= maxR ? (maxR - minR + 1) * (maxC - minC + 1) : 0;
	}

	private int[][] rotateGrid(int[][] grid) {
		int rowLength = grid.length, colLength = grid[0].length;
		int[][] rotated = new int[colLength][rowLength];
		for (int r = 0; r < rowLength; r++) {
			for (int c = 0; c < colLength; c++) {
				rotated[c][r] = grid[r][c];
			}
		}
		return rotated;
	}
}