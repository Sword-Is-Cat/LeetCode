package Medium.no1079;

class Solution {

	int[][] combination;

	public int numTilePossibilities(String tiles) {

		combination = new int[8][8];
		int[] count = new int[26];
		for (char ch : tiles.toCharArray()) {
			count[ch - 'A']++;
		}
		int answer = 0;

		for (int targetLength = 1; targetLength <= tiles.length(); targetLength++) {
			answer += dfs(0, targetLength, count);
		}

		return answer;

	}

	private int dfs(int currIdx, int targetLength, int[] count) {
		if (currIdx == targetLength) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				count[i]--;
				result += dfs(currIdx + 1, targetLength, count);
				count[i]++;
			}
		}
		return result;
	}

}