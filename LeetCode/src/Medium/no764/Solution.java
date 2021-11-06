package Medium.no764;

class Solution {
	public int orderOfLargestPlusSign(int n, int[][] mines) {

		boolean[][] mineMap = new boolean[n][n];

		for (int[] mine : mines)
			mineMap[mine[0]][mine[1]] = true;

		int check = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (!boom(i, j, n, mineMap)) {
					check = Math.max(check, 0);

					for (int length = 1; length < n; length++) {
						
						if(boom(i-length, j, n, mineMap) ||
								boom(i+length, j, n, mineMap)||
								boom(i, j-length, n, mineMap)||
								boom(i, j+length, n, mineMap)) {
							break;
						}else {
							check = Math.max(check, length);
						}
						
					}

				}

			}
		}

		return check+1;

	}

	boolean boom(int i, int j, int n, boolean[][] mineMap) {

		if (i > -1 && j > -1 && i < n && j < n && !mineMap[i][j])
			return false;

		return true;

	}
}