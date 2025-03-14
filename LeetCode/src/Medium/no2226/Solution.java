package Medium.no2226;

class Solution {
	public int maximumCandies(int[] candies, long k) {

		int pos = 0, impos = (int) 1e7 + 1;

		while (impos - pos > 1) {
			int mid = (pos + impos) / 2;
			if (possible(candies, mid, k)) {
				pos = mid;
			} else {
				impos = mid;
			}
		}

		return pos;
	}

	private boolean possible(int[] candies, int check, long k) {
		long count = 0;
		for (int candy : candies) {
			count += candy / check;
		}
		return count >= k;
	}
}