package Medium.no1861;

class Solution {
	public char[][] rotateTheBox(char[][] box) {

		char[][] grid = new char[box[0].length][box.length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < box.length; j++) {
				grid[i][j] = box[box.length - 1 - j][i];
			}
		}

		for (int c = 0; c < grid[0].length; c++) {

			int stackP = -1;

			for (int r = grid.length - 1; r >= 0; r--) {
				switch (grid[r][c]) {
				case '*':
					stackP = -1;
					break;
				case '.':
					if (stackP == -1)
						stackP = r;
					break;
				case '#':
					if (stackP == -1)
						stackP = r;
					grid[r][c] = '.';
					grid[stackP--][c] = '#';
					break;
				}
			}
		}

		return grid;
	}
}