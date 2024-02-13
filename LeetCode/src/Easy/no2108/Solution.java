package Easy.no2108;

class Solution {
	public String firstPalindrome(String[] words) {

		for (String word : words) {
			if (isPalindrom2(word))
				return word;
		}

		return "";
	}

	private boolean isPalindrom(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	private boolean isPalindrom2(String str) {
		boolean flag = true;

		for (int i = 0; flag && 2 * i < str.length() - 1; i++) {
			flag &= str.charAt(i) == str.charAt(str.length() - 1 - i);
		}

		return flag;
	}
}