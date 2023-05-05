package Medium.no1456;

class Solution {
	public int maxVowels(String s, int k) {

		char[] arr = s.toCharArray();
		boolean[] vowel = new boolean[arr.length];
		int cnt = 0, max = 0;

		for (int i = 0; i < arr.length; i++) {

			vowel[i] = isVowel(arr[i]);

			if (vowel[i])
				cnt++;
			if (0 <= i - k && vowel[i - k])
				cnt--;

			max = Math.max(max, cnt);

		}
		return max;

	}

	private boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}