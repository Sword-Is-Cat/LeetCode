package Medium.no1578;

class Solution {
	public int minCost(String colors, int[] neededTime) {

		char[] balloon = colors.toCharArray();
		int ans = 0, max = 0;
		char prev = '0';

		for (int i = 0; i < balloon.length; i++) {
			if (balloon[i] == prev) {
				ans += Math.min(max, neededTime[i]);
				max = Math.max(max, neededTime[i]);
			} else {
				prev = balloon[i];
				max = neededTime[i];
			}
		}

		return ans;
	}
}