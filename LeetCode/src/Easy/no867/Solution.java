package Easy.no867;

class Solution {
	public int[][] transpose(int[][] matrix) {

		int[][] ans = new int[matrix[0].length][matrix.length];

		for (int row = 0; row < ans.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				ans[row][col] = matrix[col][row];
			}
		}

		return ans;
	}
}