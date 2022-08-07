package Hard.ex1220;

class Solution {

	final static long MOD = 1000000007;

	public int countVowelPermutation(int n) {

		long[] arr = { 1, 1, 1, 1, 1 };

		while (n-- > 1) {

			long[] temp = new long[5];

			temp[0] = (arr[1]) % MOD;
			temp[1] = (arr[0] + arr[2]) % MOD;
			temp[2] = (arr[0] + arr[1] + arr[3] + arr[4]) % MOD;
			temp[3] = (arr[2] + arr[4]) % MOD;
			temp[4] = (arr[0]) % MOD;

			arr = temp;

		}

		return (int) ((arr[0] + arr[1] + arr[2] + arr[3] + arr[4]) % MOD);

	}
}