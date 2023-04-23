package Hard.no1416;

class Solution {

	final int MOD = (int) Math.pow(10, 9) + 7;
	char[] arr;
	int kleng, k;
	Integer[] dp;

	public int numberOfArrays(String s, int k) {

		arr = s.toCharArray();
		kleng = Integer.toString(k).length();
		this.k = k;
		dp = new Integer[arr.length + 1];

		return calcDP(arr.length);
	}

	private int calcDP(int index) {

		if (index == 0)
			return 1;

		if (dp[index] == null) {

			dp[index] = 0;
			StringBuilder num = new StringBuilder();

			for (int i = 0; i < kleng && i < index; i++) {

				char insertChar = arr[index - 1 - i];

				num.insert(0, insertChar);
				if (insertChar == '0')
					continue;

				long val = Long.parseLong(num.toString());

				if (k < val)
					break;

				dp[index] += calcDP(index - 1 - i);
				dp[index] %= MOD;
			}
		}
		return dp[index];
	}
}