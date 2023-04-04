package Medium.no2405;

class Solution {
	public int partitionString(String s) {

		boolean[] visit = new boolean[26];
		int cnt = 1;

		for (char ch : s.toCharArray()) {
			if (visit[ch - 'a']) {
				visit = new boolean[26];
				cnt++;
			}
			visit[ch - 'a'] = true;
		}
		return cnt;
	}
}