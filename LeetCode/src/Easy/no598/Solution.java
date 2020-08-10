package Easy.no598;

class Solution {
	public int maxCount(int m, int n, int[][] ops) {

		if (ops.length == 0)
			return m * n;

		int minI = Integer.MAX_VALUE;
		int minJ = Integer.MAX_VALUE;

		for (int i = 0; i < ops.length; i++) {
			minI = Math.min(minI, ops[i][0]);
			minJ = Math.min(minJ, ops[i][1]);
		}

		return minI * minJ;
	}
}