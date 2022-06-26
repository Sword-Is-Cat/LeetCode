package Medium.no1423;

class Solution_ {
	public int maxScore(int[] cardPoints, int k) {

		int[] leftSum = new int[k + 1], rightSum = new int[k + 1];

		for (int i = 0; i <= k; i++) {

			leftSum[i] = i == 0 ? 0 : cardPoints[i - 1] + leftSum[i - 1];
			rightSum[k - i] = i == 0 ? 0 : cardPoints[cardPoints.length - i] + rightSum[k - i + 1];

			System.out.println("i:" + i + ", left:" + leftSum[i] + ", right:" + rightSum[k - i]);

		}

		int ans = 0;

		for (int i = 0; i <= k; i++)
			ans = Math.max(ans, leftSum[i] + rightSum[i]);

		return ans;

	}
}