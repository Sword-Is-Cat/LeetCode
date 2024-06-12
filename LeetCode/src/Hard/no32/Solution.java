package Hard.no32;

class Solution {
	public int longestValidParentheses(String s) {

		int ans = 0, temp = 0;

		int start = -1;
		for (int i = 0; i < s.length(); i++) {
			temp += s.charAt(i) == '(' ? 1 : -1;
			if (temp < 0) {
				temp = 0;
				start = i;
			}
			if (temp == 0) {
				ans = Math.max(ans, i - start);
			}
		}

		temp = 0;
		int end = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i) == ')' ? 1 : -1;
			if (temp < 0) {
				temp = 0;
				end = i;
			}
			if (temp == 0) {
				ans = Math.max(ans, end - i);
			}
		}
		return ans;
	}
}