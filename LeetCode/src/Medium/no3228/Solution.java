package Medium.no3228;

class Solution {
	public int maxOperations(String s) {
		int stack = 0, ans = 0;
		char prev = '9';
		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				stack++;
			} else if (prev == '1') {
				ans += stack;
			}
			prev = ch;
		}
		return ans;
	}
}