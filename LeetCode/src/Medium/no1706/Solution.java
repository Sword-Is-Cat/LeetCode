package Medium.no1706;

class Solution {
	public int[] findBall(int[][] grid) {

		int[] arr = new int[grid[0].length];

		for (int idx = 0; idx < arr.length; idx++)
			arr[idx] = fallOneRow(grid, idx, 0);

		return arr;
	}

	int fallOneRow(int[][] grid, int idx, int row) {

		// [END] when a ball fall to bottom
		if (row == grid.length)
			return idx;

		int[] myRow = grid[row++];

		// [CHECK] where a ball flow to
		if (myRow[idx] == 1) {

			// [CASE RIGHT] check a ball stuck
			if (idx == myRow.length - 1 || myRow[idx + 1] == -1) {
				return -1;
			}
			idx++;
		} else {

			// [CASE LEFT] check a ball stuck
			if (idx == 0 || myRow[idx - 1] == 1) {
				return -1;
			}
			idx--;
		}
		return fallOneRow(grid, idx, row);
	}
}