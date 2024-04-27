package Hard.no514;

import java.util.ArrayList;
import java.util.List;

class Solution {

	int ringLength;

	public int findRotateSteps(String ring, String key) {

		ringLength = ring.length();
		List<List<Integer>> charIdx = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			charIdx.add(new ArrayList<>());
		}

		char[] ringArr = ring.toCharArray();
		char[] keyArr = key.toCharArray();
		int[][] dp = new int[keyArr.length][ringArr.length];

		for (int i = 0; i < ringArr.length; i++) {
			charIdx.get(ringArr[i] - 'a').add(i);
		}

		int ans = Integer.MAX_VALUE;

		for (int i : charIdx.get(keyArr[0] - 'a')) {
			dp[0][i] = calcMove(0, i) + 1;
			if (keyArr.length == 1) {
				ans = Math.min(ans, dp[0][i]);
			}
		}

		for (int i = 1; i < keyArr.length; i++) {
			char curr = keyArr[i], prev = keyArr[i - 1];
			for (int to : charIdx.get(curr - 'a')) {
				int temp = Integer.MAX_VALUE;
				for (int from : charIdx.get(prev - 'a')) {
					temp = Math.min(temp, dp[i - 1][from] + calcMove(from, to) + 1);
				}
				dp[i][to] = temp;
				if (i == keyArr.length - 1) {
					ans = Math.min(ans, dp[i][to]);
				}
			}
		}

		return ans;
	}

	private int calcMove(int from, int to) {
		int dist = Math.abs(from - to);
		return Math.min(dist, ringLength - dist);
	}
}