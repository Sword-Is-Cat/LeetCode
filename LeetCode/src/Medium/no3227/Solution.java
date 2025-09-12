package Medium.no3227;

class Solution {
	public boolean doesAliceWin(String s) {
		for (char ch : s.toCharArray()) {
			switch (ch) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return true;
			}
		}
		return false;
	}
}