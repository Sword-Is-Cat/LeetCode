package Medium.no1014;

class Solution {
	public int maxScoreSightseeingPair(int[] values) {

		int ans = 0, temp = values[0];

		for (int i = 1; i < values.length; i++) {
			temp--;
			ans = Math.max(ans, temp + values[i]);
			temp = Math.max(temp, values[i]);
		}

		return ans;
	}
}