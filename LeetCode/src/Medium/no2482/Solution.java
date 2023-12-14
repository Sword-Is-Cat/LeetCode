package Medium.no2482;

class Solution {
	public int[][] onesMinusZeros(int[][] grid) {

		int[] diffRow = new int[grid.length], diffCol = new int[grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int vari = grid[i][j] == 1 ? 1 : -1;
				diffRow[i] += vari;
				diffCol[j] += vari;
			}
		}

		int[][] ans = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				ans[i][j] = diffRow[i] + diffCol[j];
			}
		}

		return ans;
	}
}