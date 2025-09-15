package Easy.no1935;

class Solution {
	public int canBeTypedWords(String text, String brokenLetters) {

		boolean[] broken = new boolean[26];
		for (char ch : brokenLetters.toCharArray())
			broken[ch - 'a'] = true;

		int answer = 0;
		for (String word : text.split(" ")) {
			if (canType(word, broken))
				answer++;
		}
		return answer;
	}

	public boolean canType(String word, boolean[] broken) {
		for (char ch : word.toCharArray())
			if (broken[ch - 'a'])
				return false;
		return true;
	}
}