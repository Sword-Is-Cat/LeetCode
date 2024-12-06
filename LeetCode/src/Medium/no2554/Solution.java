package Medium.no2554;

class Solution {
	public int maxCount(int[] banned, int n, int maxSum) {

		boolean[] isBan = new boolean[n + 1];
		for (int ban : banned) {
			if (ban <= n)
				isBan[ban] = true;
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (!isBan[i] && maxSum >= i) {
				cnt++;
				maxSum -= i;
			}
		}

		return cnt;

	}
}