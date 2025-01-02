package Medium.no2559;

class Solution {
	public int[] vowelStrings(String[] words, int[][] queries) {

		int[] cnts = new int[words.length + 1];
		for (int i = 0; i < words.length; i++) {
			cnts[i + 1] = cnts[i] + (isVowelString(words[i]) ? 1 : 0);
		}

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			ans[i] = cnts[query[1] + 1] - cnts[query[0]];
		}
		return ans;

	}

	private boolean isVowelString(String word) {
		return "aeiou".indexOf(word.charAt(0)) != -1 && "aeiou".indexOf(word.charAt(word.length() - 1)) != -1;
	}
}