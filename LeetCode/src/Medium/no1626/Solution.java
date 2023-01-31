package Medium.no1626;

import java.util.Arrays;

class Solution {
	public int bestTeamScore(int[] scores, int[] ages) {

		int[][] arr = new int[scores.length][2];
		for (int i = 0; i < scores.length; i++) {
			arr[i][0] = scores[i];
			arr[i][1] = ages[i];
		}

		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int[] cache = new int[1001];

		for (int[] player : arr) {
			int score = player[0], age = player[1];
			int max = 0;
			for (int a = 0; a <= age; a++) {
				max = Math.max(max, cache[a]);
			}
			cache[age] = max + score;
		}

		return Arrays.stream(cache).max().getAsInt();
	}
}