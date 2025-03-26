package Medium.no2033;

import java.util.Arrays;

class Solution {
	public int minOperations(int[][] grid, int x) {

		int[] arr = new int[grid.length * grid[0].length];

		int remain = grid[0][0] % x;
		int answer = Integer.MAX_VALUE;
		int left = 0, right = 0;

		for (int i = 0; i < arr.length; i++) {
			int value = grid[i % grid.length][i / grid.length];
			if (value % x != remain) {
				return -1;
			}
			arr[i] = value / x;
			right += arr[i];
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			right -= arr[i];

			answer = Math.min(answer, arr[i] * i - left + right - arr[i] * (arr.length - i - 1));

			left += arr[i];
		}
		return answer;
	}
}