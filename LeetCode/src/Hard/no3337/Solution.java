package Hard.no3337;

import java.util.List;

class Solution {

	private final static int MOD = 1_000_000_007;

	public int lengthAfterTransformations(String s, int t, List<Integer> nums) {

		int[][] matrix = new int[26][26];
		for (int i = 0; i < 26; i++) {
			for (int j = 1; j <= nums.get(i); j++) {
				matrix[i][(i + j) % 26] = 1;
			}
		}

		matrix = fullyApplyMatrix(matrix, t);

		int[] cnt = new int[26];
		for (char ch : s.toCharArray()) {
			cnt[ch - 'a']++;
		}

		long answer = 0;

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				answer = (answer + 1L * cnt[i] * matrix[i][j]) % MOD;
			}
		}

		return (int) answer;
	}

	private int[][] fullyApplyMatrix(int[][] matrix, int t) {
		int[][] result = new int[26][26];
		for (int i = 0; i < 26; i++)
			result[i][i] = 1;
		while (t > 0) {
			if (t % 2 == 0) {
				matrix = applyMatrix(matrix, matrix);
				t /= 2;
			} else {
				result = applyMatrix(result, matrix);
				t--;
			}
		}
		return result;
	}

	private int[][] applyMatrix(int[][] matrix1, int[][] matrix2) {
		int[][] result = new int[26][26];
		for (int s = 0; s < 26; s++) {
			for (int m = 0; m < 26; m++) {
				for (int e = 0; e < 26; e++) {
					result[s][e] = (int) ((result[s][e] + 1L * matrix1[s][m] * matrix2[m][e]) % MOD);
				}
			}
		}
		return result;
	}
}