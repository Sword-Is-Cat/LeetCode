package Medium.no1105;

class Solution {
	public int minHeightShelves(int[][] books, int shelfWidth) {

		int length = books.length;
		int[] dp = new int[length + 1];

		for (int i = 1; i <= length; i++) {

			int[] book = books[i - 1];
			int width = book[0], height = book[1];

			dp[i] = dp[i - 1] + height;

			for (int j = i - 1; j > 0; j--) {
				width += books[j - 1][0];
				height = Math.max(height, books[j - 1][1]);
				if (width > shelfWidth) {
					break;
				}
				dp[i] = Math.min(dp[i], dp[j - 1] + height);
			}

		}

		return dp[length];
	}
}