package Challenge.August2nd_1;

class Solution {
	public int orangesRotting(int[][] grid) {

		int min = 0;
		int sum = sum(grid);

		while (!checkRotten(grid)) {
			grid = nextMin(grid);
			min++;
			int newSum = sum(grid);

			if (sum == newSum) {
				System.out.println("return-1");
				return -1;
			} else {
				System.out.println("min+1");
				sum = newSum;
			}
		}

		return min;

	}

	int sum(int[][] grid) {

		int result = 0;

		for (int[] arr : grid) {
			for (int i : arr) {
				result += i;
			}
		}

		return result;

	}

	int[][] nextMin(int[][] grid) {

		int[][] result = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				result[i][j] = grid[i][j];
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					if (i > 0)
						result[i - 1][j] = result[i - 1][j] == 1 ? 2 : result[i - 1][j];
					if (j > 0)
						result[i][j - 1] = result[i][j - 1] == 1 ? 2 : result[i][j - 1];
					if (i + 1 < grid.length)
						result[i + 1][j] = result[i + 1][j] == 1 ? 2 : result[i + 1][j];
					if (j + 1 < grid[i].length)
						result[i][j + 1] = result[i][j + 1] == 1 ? 2 : result[i][j + 1];
				}
			}
		}

		return result;

	}

	boolean checkRotten(int[][] grid) {

		boolean result = true;

		for (int[] arr : grid) {

			if (!result)
				break;

			for (int i : arr) {

				if (i == 1) {

					result = false;
					break;

				}
			}
		}

		return result;
	}
}