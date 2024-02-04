package Hard.no76;

class Solution {
	public String minWindow(String s, String t) {

		int[] myCounter = new int[52], targetCounter = new int[52];

		for (char ch : t.toCharArray()) {
			targetCounter[charToInt(ch)]++;
		}

		int ansL = 0, ansR = s.length() + 1;
		int left = 0, right = 0;

		while (left < s.length() || right < s.length()) {

			boolean isValid = isWindowValid(myCounter, targetCounter);
			if (isValid) {
				if (ansR - ansL > right - left) {
					ansR = right;
					ansL = left;
				}
			}

			if (right == s.length() || isValid) {
				myCounter[charToInt(s.charAt(left++))]--;
			} else {
				myCounter[charToInt(s.charAt(right++))]++;
			}

		}

		if (ansR == s.length() + 1)
			ansR = 0;

		return s.substring(ansL, ansR);
	}

	private int charToInt(char ch) {
		if (Character.isLowerCase(ch))
			return ch - 'a' + 26;
		else
			return ch - 'A';
	}

	private boolean isWindowValid(int[] myCounter, int[] targetCounter) {
		boolean result = true;
		for (int i = 0; result && i < myCounter.length; i++) {
			result &= myCounter[i] >= targetCounter[i];
		}
		return result;
	}
}