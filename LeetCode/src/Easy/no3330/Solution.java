package Easy.no3330;

class Solution {
	public int possibleStringCount(String word) {
		int ans = 0;
		char prev = word.charAt(0);
		for (char ch : word.toCharArray()) {
			if (ch == prev) {
				ans++;
			} else {
				prev = ch;
			}
		}
		return ans;
	}
}