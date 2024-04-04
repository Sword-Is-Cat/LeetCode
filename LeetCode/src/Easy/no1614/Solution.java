package Easy.no1614;

class Solution {
	public int maxDepth(String s) {

		int answer = 0, cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				answer = Math.max(answer, ++cnt);
			} else if (ch == ')') {
				cnt--;
			}
		}

		return answer;
	}
}