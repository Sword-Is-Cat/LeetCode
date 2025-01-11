package Medium.no1400;

class Solution {
	public boolean canConstruct(String s, int k) {

		if (s.length() < k)
			return false;

		int[] cnt = new int[26];
		for (char ch : s.toCharArray())
			cnt[ch - 'a']++;

		int min = 0;

		for (int c : cnt) {
			if (c % 2 == 1)
				min++;
		}

		return min <= k;
	}
}