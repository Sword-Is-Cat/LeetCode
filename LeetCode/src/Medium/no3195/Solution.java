package Medium.no3195;

class Solution {
	public int minimumArea(int[][] grid) {
		int maxR = -1, minR = grid.length, maxC = -1, minC = grid[0].length;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					maxR = Math.max(maxR, r);
					minR = Math.min(minR, r);
					maxC = Math.max(maxC, c);
					minC = Math.min(minC, c);
				}
			}
		}
		return (maxR - minR + 1) * (maxC - minC + 1);
	}
}