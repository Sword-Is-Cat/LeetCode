package Medium.no1395;

class Solution {
	public int numTeams(int[] rating) {

		int ans = 0, length = rating.length;

		for (int mid = 0; mid < length; mid++) {

			int leftLower = 0, leftUpper = 0, rightLower = 0, rightUpper = 0;

			for (int left = 0; left < mid; left++) {
				if (rating[left] < rating[mid]) {
					leftLower++;
				} else {
					leftUpper++;
				}
			}
			for (int right = mid + 1; right < length; right++) {
				if (rating[mid] < rating[right]) {
					rightUpper++;
				} else {
					rightLower++;
				}
			}

			ans += leftLower * rightUpper;
			ans += leftUpper * rightLower;

		}

		return ans;

	}
}