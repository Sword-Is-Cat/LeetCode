package Easy.no58;

public class Solution {
	public int lengthOfLastWord(String s) {

		int cnt = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				if (cnt > 0) {
					return cnt;
				}
			} else {
				cnt++;
			}
		}
		return cnt;
	}
}
