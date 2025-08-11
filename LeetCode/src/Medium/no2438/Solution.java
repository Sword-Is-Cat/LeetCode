package Medium.no2438;

class Solution {

	private final int MOD = 1_000_000_007;

	public int[] productQueries(int n, int[][] queries) {
		int[] values = new int[Integer.bitCount(n)];
		int val = 1, idx = 0;
		while (n > 0) {
			if (n % 2 == 1)
				values[idx++] = val;
			val *= 2;
			n >>= 1;
		}
		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			long result = 1;
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				result = (result * values[j]) % MOD;
			}
			answer[i] = (int) result;
		}
		return answer;
	}
}