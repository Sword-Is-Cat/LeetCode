package Easy.no3042;

class Solution {
	public int countPrefixSuffixPairs(String[] words) {

		int ans = 0;

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (isPrefixAndSuffix(words[i], words[j]))
					ans++;
			}
		}

		return ans;
	}

	private boolean isPrefixAndSuffix(String str1, String str2) {
		return str2.indexOf(str1) == 0 && str2.lastIndexOf(str1) == str2.length() - str1.length();
	}
}