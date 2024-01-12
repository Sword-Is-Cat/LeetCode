package Easy.no1704;

class Solution {
	public boolean halvesAreAlike(String s) {

		int left = 0, right = s.length() - 1;
		int cnt = 0;

		while (left < right) {
			if (isVowel(s.charAt(left++)))
				cnt++;
			if (isVowel(s.charAt(right--)))
				cnt--;
		}

		return cnt == 0;
	}

	private boolean isVowel(char ch) {
		return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
				|| ch == 'u' || ch == 'U';
	}
}