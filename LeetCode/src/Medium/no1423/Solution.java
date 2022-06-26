package Medium.no1423;

public class Solution {

	public int maxScore(int[] cardPoints, int k) {

		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += cardPoints[i];
		}

		int ans = sum;

		for (int i = 0; i < k; i++) {

			sum -= cardPoints[k - 1 - i] - cardPoints[cardPoints.length - 1 - i];
			ans = Math.max(ans, sum);

		}
		return ans;
	}

}
