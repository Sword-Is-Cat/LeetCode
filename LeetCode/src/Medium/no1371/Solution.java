package Medium.no1371;

import java.util.Arrays;

class Solution {
	public int findTheLongestSubstring(String s) {

		int[] charArr = { 1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0 };
		int[] firstPosition = new int[32];
		Arrays.fill(firstPosition, -2);
		firstPosition[0] = -1;

		int temp = 0, ans = 0;

		for (int i = 0; i < s.length(); i++) {

			temp ^= charArr[s.charAt(i) - 'a'];

			if (firstPosition[temp] == -2)
				firstPosition[temp] = i;
			else
				ans = Math.max(ans, i - firstPosition[temp]);
		}

		return ans;

	}
}