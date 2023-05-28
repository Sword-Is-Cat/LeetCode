package Medium.no934;

import java.util.HashSet;

class Solution {

	int[][] grid;

	public int shortestBridge(int[][] grid) {

		this.grid = grid;
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		HashSet<int[]> prev, curr = new HashSet<>();

		breakpoint: // outer loop
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 1) {
					visitFirstIsland(row, col, curr, visit);
					break breakpoint;
				}
			}
		}

		int distance = 0;

		int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!curr.isEmpty()) {

			prev = curr;
			curr = new HashSet<>();

			for (int[] coord : prev) {
				int row = coord[0], col = coord[1];

				for (int d = 0; d < 4; d++) {

					int nRow = row + direct[d][0], nCol = col + direct[d][1];
					if (nRow < 0 || nCol < 0 || nRow == grid.length || nCol == grid[nRow].length || visit[nRow][nCol]) {
						// invalid coord or visited
						continue;
					}

					visit[nRow][nCol] = true;

					if (grid[nRow][nCol] == 1) {
						return distance;
					}

					curr.add(new int[] { nRow, nCol });

				}

			}

			distance++;

		}

		return -1;
	}

	private void visitFirstIsland(int row, int col, HashSet<int[]> container, boolean[][] visit) {

		if (row < 0 || col < 0 || row == grid.length || col == grid[row].length) {
			// invalid coord
			return;
		}

		if (visit[row][col] || grid[row][col] != 1) {
			// visited or not island
			return;
		}

		container.add(new int[] { row, col });
		visit[row][col] = true;

		visitFirstIsland(row + 1, col, container, visit);
		visitFirstIsland(row - 1, col, container, visit);
		visitFirstIsland(row, col + 1, container, visit);
		visitFirstIsland(row, col - 1, container, visit);

	}
}