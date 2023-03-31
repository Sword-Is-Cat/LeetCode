package Hard.no1444;

class Solution {

	final int MOD = 1000000007;
	char[][] grid;
	Integer[][][] cache;
	int rowMax, colMax;

	public int ways(String[] pizza, int k) {

		grid = new char[pizza.length][];
		for (int i = 0; i < pizza.length; i++) {
			grid[i] = pizza[i].toCharArray();
		}

		rowMax = grid.length;
		colMax = grid[0].length;

		cache = new Integer[grid.length][grid[0].length][k];

		return calculate(0, 0, k - 1);
	}

	/**
	 * row,col부터 시작하는 피자를 cut회 잘랐을때의 경우의수 계산
	 */
	private int calculate(int row, int col, int cut) {

		if (grid.length == row || grid[0].length == col || cut < 0)
			return 0;

		if (cache[row][col][cut] == null) {

			int value = 0;

			if (cut == 0) {

				// 자르지 않음: 남은 피자에 사과가 있으면 1가지 경우의수
				boolean hasApple = false;

				for (int i = row; !hasApple && i < rowMax; i++)
					hasApple |= hasApple(i, col, 'h');

				if (hasApple)
					value = 1;

			} else {

				boolean hasApple;

				// 가로로 자르는 경우
				hasApple = false;
				for (int i = row; i < rowMax; i++) {
					hasApple |= hasApple(i, col, 'h');
					if (hasApple) {
						value += calculate(i + 1, col, cut - 1);
						value %= MOD;
					}
				}

				// 세로로 자르는 경우
				hasApple = false;
				for (int i = col; i < colMax; i++) {
					hasApple |= hasApple(row, i, 'v');
					if (hasApple) {
						value += calculate(row, i + 1, cut - 1);
						value %= MOD;
					}
				}

			}

			cache[row][col][cut] = value;

		}

//		System.out.println("calculate [" + row + "," + col + "," + cut + "] : " + cache[row][col][cut]);

		return cache[row][col][cut];
	}

	/**
	 * row,col 부터 해당방향의 끝까지에 사과가 있는지 return
	 */
	private boolean hasApple(int row, int col, char direct) {

		boolean hasApple = false;

		if (direct == 'v') {
			for (int i = row; !hasApple && i < rowMax; i++)
				hasApple |= grid[i][col] == 'A';
		} else if (direct == 'h') {
			for (int i = col; !hasApple && i < colMax; i++)
				hasApple |= grid[row][i] == 'A';
		}

		return hasApple;
	}

}