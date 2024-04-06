package Medium.no1249;

class Solution {
	public String minRemoveToMakeValid(String s) {

		StringBuilder sb = new StringBuilder();
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case ')':
				if (cnt > 0) {
					sb.append(ch);
					cnt--;
				}
				break;
			case '(':
				cnt++;
			default:
				sb.append(ch);
			}
		}

		s = sb.toString();
		sb = new StringBuilder();
		cnt = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			switch (ch) {
			case '(':
				if (cnt > 0) {
					sb.append(ch);
					cnt--;
				}
				break;
			case ')':
				cnt++;
			default:
				sb.append(ch);
			}
		}

		s = sb.reverse().toString();

		return s;
	}
}