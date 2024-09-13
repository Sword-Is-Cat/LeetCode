package Medium.no1310;

class Solution {
	public int[] xorQueries(int[] arr, int[][] queries) {

		int[] xor = new int[arr.length + 1];
		for (int i = 1; i < xor.length; i++)
			xor[i] = xor[i - 1] ^ arr[i - 1];

		int[] ans = new int[queries.length];
		for (int i = 0; i < ans.length; i++)
			ans[i] = xor[queries[i][1] + 1] ^ xor[queries[i][0]];

		return ans;

	}
}