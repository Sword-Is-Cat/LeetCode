package Medium.no498;

class Solution {
	public int[] findDiagonalOrder(int[][] mat) {

		int rowMax = mat.length, colMax = mat[0].length;
		int[] ans = new int[rowMax * colMax];
		int idx = 0;

		for (int sum = 0; sum < rowMax + colMax - 1; sum++) {
			if (sum % 2 == 0) {
				for (int col = 0; col <= sum; col++) {
					int row = sum - col;
					if (row >= 0 && col >= 0 && row < rowMax && col < colMax) {
						ans[idx++] = mat[row][col];
					}
				}
			} else {
				for (int row = 0; row <= sum; row++) {
					int col = sum - row;
					if (row >= 0 && col >= 0 && row < rowMax && col < colMax) {
						ans[idx++] = mat[row][col];
					}
				}
			}
		}

		return ans;
	}
}