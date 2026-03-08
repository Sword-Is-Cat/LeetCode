package Easy.no1784;

class Solution {
	public boolean checkOnesSegment(String s) {

		boolean meetZero = false;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '0') {
				meetZero = true;
			} else if (meetZero) {
				return false;
			}
		}

		return true;
	}
}