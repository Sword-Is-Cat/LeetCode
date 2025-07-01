package Easy.no3330;

class Solution {
	public int possibleStringCount(String word) {
		int cnt = 0, ans = 1;
		char prev = word.charAt(0);
		for (char ch : word.toCharArray()) {
			if (ch == prev) {
				cnt++;
			} else {
				ans += cnt - 1;
				prev = ch;
				cnt = 1;
			}
		}
		return ans + cnt - 1;
	}
}