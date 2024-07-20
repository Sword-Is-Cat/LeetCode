package Medium.no1605;

class Solution {
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

		int[][] answer = new int[rowSum.length][colSum.length];

		for (int i = 0, j = 0; i < rowSum.length && j < colSum.length;) {
			if (rowSum[i] < colSum[j]) {
				answer[i][j] = rowSum[i];
				colSum[j] -= rowSum[i];
				i++;
			} else {
				answer[i][j] = colSum[j];
				rowSum[i] -= colSum[j];
				j++;
			}
		}

		return answer;

	}
}