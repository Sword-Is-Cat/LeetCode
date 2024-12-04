package Medium.no2825;

class Solution {
	public boolean canMakeSubsequence(String str1, String str2) {

		int idx = 0;

		for (int i = 0; i < str1.length() && idx < str2.length(); i++) {
			if ((str2.charAt(idx) - str1.charAt(i) + 26) % 26 < 2)
				idx++;
		}

		return idx == str2.length();
	}
}