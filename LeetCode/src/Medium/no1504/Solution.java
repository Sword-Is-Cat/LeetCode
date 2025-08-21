package Medium.no1504;

class Solution {
	public int numSubmat(int[][] mat) {
		int ans = 0;
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[r].length; c++) {
				if (mat[r][c] != 0 && c > 0) {
					mat[r][c] = mat[r][c - 1] + 1;
				}
				int width = mat[r][c];
				for (int t = r; t >= 0; t--) {
					width = Math.min(width, mat[t][c]);
					ans += width;
				}
			}
		}
		return ans;
	}
}