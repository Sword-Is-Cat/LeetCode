package Medium.no3227;

class Solution {
	public boolean doesAliceWin(String s) {
		String vowel = "aeiou";
		for (char ch : s.toCharArray()) {
			if (vowel.indexOf(ch) != -1)
				return true;
		}
		return false;
	}
}