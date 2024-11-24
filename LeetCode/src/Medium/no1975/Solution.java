package Medium.no1975;

class Solution {
	public long maxMatrixSum(int[][] matrix) {

		int cntNeg = 0, minVal = Integer.MAX_VALUE;
		long sum = 0;

		for (int[] row : matrix) {
			for (int val : row) {
				if (val < 0) {
					cntNeg++;
					val *= -1;
				}
				sum += val;
				minVal = Math.min(minVal, val);
			}
		}

		if (cntNeg % 2 == 1) {
			sum -= 2 * minVal;
		}

		return sum;
	}
}