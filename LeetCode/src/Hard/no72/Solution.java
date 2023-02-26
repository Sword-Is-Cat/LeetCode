package Hard.no72;

class Solution {

	int[][] cache;
	char[] str1, str2;
	int length1, length2;

	public int minDistance(String word1, String word2) {

		str1 = word1.toCharArray();
		str2 = word2.toCharArray();
		length1 = str1.length;
		length2 = str2.length;
		cache = new int[length1][length2];

		return dfs(0, 0);
	}

	protected int dfs(int idx1, int idx2) {

		if (idx1 == length1 || idx2 == length2)
			return length1 + length2 - idx1 - idx2;

		if (cache[idx1][idx2] == 0) {

			int result = -1;

			if (str1[idx1] == str2[idx2]) {
				// 두 글자일치, 작업없이 다음 index로
				result = dfs(idx1 + 1, idx2 + 1);
			} else {
				// 불일치 3가지 case 체크
				int insert = 1 + dfs(idx1, idx2 + 1);
				int delete = 1 + dfs(idx1 + 1, idx2);
				int replace = 1 + dfs(idx1 + 1, idx2 + 1);
				result = Math.min(replace, Math.min(insert, delete));
			}
			cache[idx1][idx2] = result;

		}

		return cache[idx1][idx2];
	}
}