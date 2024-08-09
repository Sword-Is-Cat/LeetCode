package Medium.no840;

import java.util.Arrays;

class Solution {
	public int numMagicSquaresInside(int[][] grid) {

		int ans = 0;
		int[] cnts = new int[16];
		int[] rowSum = new int[3], colSum = new int[3];

		for (int r = 0; r + 2 < grid.length; r++) {
			for (int c = 0; c + 2 < grid[r].length; c++) {

				Arrays.fill(cnts, 0);
				Arrays.fill(rowSum, 0);
				Arrays.fill(colSum, 0);
				boolean isDistinct = true;

				for (int rd = 0; rd < 3; rd++) {
					for (int cd = 0; cd < 3; cd++) {
						cnts[grid[r + rd][c + cd]]++;
						rowSum[rd] += grid[r + rd][c + cd];
						colSum[cd] += grid[r + rd][c + cd];
					}
				}

				for (int num = 0; num < cnts.length; num++) {
					isDistinct &= (0 < num && num < 10 && cnts[num] == 1) || ((num == 0 || 9 < num) && cnts[num] == 0);
				}

				if (isDistinct) {
					int diaSum1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2],
							diaSum2 = grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2];

					if (diaSum1 == diaSum2 && rowSum[0] == rowSum[1] && rowSum[1] == rowSum[2] && colSum[0] == colSum[1]
							&& colSum[1] == colSum[2] && diaSum1 == rowSum[0] && rowSum[0] == colSum[0])
						ans++;
				}

			}
		}

		return ans;

	}
}