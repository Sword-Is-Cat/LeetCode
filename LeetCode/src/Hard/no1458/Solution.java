package Hard.no1458;

import java.util.Arrays;

class Solution {

	int[] arr1, arr2;
	int leng1, leng2;
	int[][] dp;

	public int maxDotProduct(int[] nums1, int[] nums2) {

		arr1 = nums1;
		arr2 = nums2;
		leng1 = arr1.length;
		leng2 = arr2.length;
		dp = new int[leng1][leng2];

		for (int[] row : dp)
			Arrays.fill(row, Integer.MIN_VALUE);

		return calcDp(0, 0);
	}

	private int calcDp(int idx1, int idx2) {

		if (idx1 == leng1 || idx2 == leng2)
			return Integer.MIN_VALUE;

		if (dp[idx1][idx2] == Integer.MIN_VALUE) {

			dp[idx1][idx2] = Math.max(arr1[idx1] * arr2[idx2] + Math.max(0, calcDp(idx1 + 1, idx2 + 1)),
					Math.max(calcDp(idx1 + 1, idx2), calcDp(idx1, idx2 + 1)));

		}

		return dp[idx1][idx2];
	}
}