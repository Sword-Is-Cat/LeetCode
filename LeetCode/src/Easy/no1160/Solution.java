package Easy.no1160;

class Solution {
	public int countCharacters(String[] words, String chars) {

		int[] charsCount = charCount(chars);
		int ans = 0;

		for (String word : words) {

			int[] targetCount = charCount(word);
			boolean flag = true;
			for (int i = 0; flag && i < 26; i++) {
				if (charsCount[i] < targetCount[i])
					flag = false;
			}
			if (flag)
				ans += word.length();

		}

		return ans;
	}

	private int[] charCount(String str) {

		int[] counter = new int[26];

		for (int i = 0; i < str.length(); i++) {
			counter[str.charAt(i) - 'a']++;
		}

		return counter;
	}
}