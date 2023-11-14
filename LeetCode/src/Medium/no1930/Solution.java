package Medium.no1930;

class Solution {
	public int countPalindromicSubsequence(String s) {

		int[][] counter = new int[s.length() + 1][26];

		for (int i = 1; i < counter.length; i++) {
			for (int j = 0; j < 26; j++) {
				counter[i][j] = counter[i - 1][j];
			}
			counter[i][s.charAt(i - 1) - 'a']++;
		}

		boolean[][] visit = new boolean[26][26];

		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (0 < counter[i][j] && 0 < counter[s.length()][j] - counter[i + 1][j]) {
					visit[s.charAt(i) - 'a'][j] = true;
				}
			}
		}

		int ans = 0;

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (visit[i][j]) {
					ans += 1;
				}
			}
		}

		return ans;
	}
}