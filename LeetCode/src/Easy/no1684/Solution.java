package Easy.no1684;

class Solution {
	public int countConsistentStrings(String allowed, String[] words) {
		boolean[] allow = new boolean[26];
		for (char ch : allowed.toCharArray())
			allow[ch - 'a'] = true;
		int ans = 0;
		for (String word : words) {
			boolean valid = true;
			for (char ch : word.toCharArray()) {
				if (!allow[ch - 'a'])
					valid = false;
			}
			if (valid)
				ans++;
		}
		return ans;
	}
}