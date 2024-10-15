package Medium.no2938;

class Solution {
	public long minimumSteps(String s) {

		long ans = 0L;
		int swap = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				swap++;
			} else {
				ans += swap;
			}
		}

		return ans;
	}
}