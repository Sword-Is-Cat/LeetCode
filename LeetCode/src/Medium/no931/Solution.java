package Medium.no931;

class Solution {
	public int minFallingPathSum(int[][] matrix) {

		int[] prev = null;

		for (int[] curr : matrix) {
			if (prev != null) {
				for (int i = 0; i < curr.length; i++) {
					int temp = prev[i];
					if (i > 0)
						temp = Math.min(temp, prev[i - 1]);
					if (i < curr.length - 1)
						temp = Math.min(temp, prev[i + 1]);
					curr[i] += temp;
				}
			}
			prev = curr;
		}

		int ans = prev[0];
		for (int val : prev) {
			ans = Math.min(ans, val);
		}

		return ans;
	}
}