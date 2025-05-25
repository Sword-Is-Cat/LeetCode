package Medium.no2131;

class Solution {
	public int longestPalindrome(String[] words) {

		int[][] cnt = new int[26][26];

		for (String word : words) {
			cnt[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
		}

		int countPair = 0, centerWord = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i][i] % 2 == 1)
				centerWord = 2;
			countPair += cnt[i][i] / 2;
			for (int j = i+1; j < cnt[i].length; j++) {
				countPair += Math.min(cnt[i][j], cnt[j][i]);
			}
		}

		return countPair * 4 + centerWord;
	}

}