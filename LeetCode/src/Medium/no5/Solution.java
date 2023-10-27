package Medium.no5;

class Solution {
	public String longestPalindrome(String s) {

		char[] array = s.toCharArray();
		String palinString = s.substring(0, 1);

		for (int left = 0; left < s.length(); left++) {
			for (int right = left + palinString.length(); right < s.length(); right++) {
				if (isPalindrome(array, left, right)) {
					palinString = s.substring(left, right + 1);
				}
			}
		}

		return palinString;
	}

	private boolean isPalindrome(char[] array, int left, int right) {
		while (left <= right) {
			if (array[left++] != array[right--]) {
				return false;
			}
		}
		return true;
	}
}