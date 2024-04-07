package Medium.no678;

class Solution {

	public boolean checkValidString(String s) {
		return dfs(s, 0, 0, new boolean[s.length()][s.length()], new boolean[s.length()][s.length()]);
	}

	private boolean dfs(String s, int i, int cnt, boolean[][] cache, boolean[][] visit) {

		if (i == s.length())
			return cnt == 0;

		if (cnt < 0 || s.length() - i < cnt)
			return false;

		if (!visit[i][cnt]) {

			visit[i][cnt] = true;

			switch (s.charAt(i)) {
			case '(':
				cache[i][cnt] = dfs(s, i + 1, cnt + 1, cache, visit);
				break;
			case ')':
				cache[i][cnt] = dfs(s, i + 1, cnt - 1, cache, visit);
				break;
			case '*':
				cache[i][cnt] = dfs(s, i + 1, cnt - 1, cache, visit) || dfs(s, i + 1, cnt, cache, visit)
						|| dfs(s, i + 1, cnt + 1, cache, visit);
				break;
			}
		}

		return cache[i][cnt];
	}
}