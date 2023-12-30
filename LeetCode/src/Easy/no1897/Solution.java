package Easy.no1897;

class Solution {
	public boolean makeEqual(String[] words) {

		int[] counter = new int[26];

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				counter[word.charAt(i) - 'a']++;
			}
		}

		for (int i = 0; i < counter.length; i++) {
			if (counter[i] % words.length > 0)
				return false;
		}

		return true;
	}
}