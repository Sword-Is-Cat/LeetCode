package Easy.no1337;

import java.util.Arrays;

class Solution {
	public int[] kWeakestRows(int[][] mat, int k) {

		int[][] arr = new int[mat.length][2]; // [[sum, index]]

		for (int i = 0; i < mat.length; i++) {
			arr[i][0] = sumOfIntArr(mat[i]);
			arr[i][1] = i;
		}

		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int[] ans = new int[k];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = arr[i][1];
		}

		return ans;
	}

	private int sumOfIntArr(int[] arr) {
		int result = 0;
		for (int num : arr)
			result += num;
		return result;
	}
}