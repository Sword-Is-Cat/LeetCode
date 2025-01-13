package Medium.no3223;

class Solution {
	public int minimumLength(String s) {

		int[] cnts = new int[26];
		for (char ch : s.toCharArray()) {
			cnts[ch - 'a']++;
		}

		int ans = 0;
		for (int cnt : cnts) {
			if (cnt > 0) {
				ans += (cnt - 1) % 2 + 1;
			}
		}

		return ans;
	}
}