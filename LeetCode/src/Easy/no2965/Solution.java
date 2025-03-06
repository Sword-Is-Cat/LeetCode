package Easy.no2965;

class Solution {
	public int[] findMissingAndRepeatedValues(int[][] grid) {

		int n = grid.length;
		int[] answer = { 0, 0 };
		int[] freq = new int[n * n + 1];

		for (int i = 0; i < n * n; i++) {
			int value = grid[i / n][i % n];
			answer[1] ^= i + 1;
			answer[1] ^= value;
			if (freq[value]++ > 0) {
				answer[0] = value;
				answer[1] ^= value;
			}
		}

		return answer;
	}
}