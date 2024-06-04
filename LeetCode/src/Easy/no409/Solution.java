package Easy.no409;

class Solution {
	public int longestPalindrome(String s) {

		int[] cnts = new int[58];
		for (char ch : s.toCharArray()) {
			cnts[ch - 'A']++;
		}

		int ans = 0, odd = 0;

		for (int i = 0; i < cnts.length; i++) {
			ans += cnts[i] - cnts[i] % 2;
			odd |= cnts[i] % 2;
		}

		return ans + odd;

	}
}