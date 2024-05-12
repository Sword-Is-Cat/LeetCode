package Easy.no2373;

class Solution {
	public int[][] largestLocal(int[][] grid) {

		int length = grid.length;
		int[][] ans = new int[length - 2][length - 2];

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				for (int dr = 0; dr < 3; dr++) {
					for (int dc = 0; dc < 3; dc++) {

						ans[i][j] = Math.max(ans[i][j], grid[i+dr][j+dc]);
						
					}
				}
			}
		}

		return ans;

	}
}