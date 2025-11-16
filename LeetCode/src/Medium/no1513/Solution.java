package Medium.no1513;

class Solution {

	static final int MOD = 1_000_000_007;

	public int numSub(String s) {

		long result = 0;
		int stack = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				result += ++stack;
			} else {
				stack = 0;
			}
		}
		return (int)(result%MOD);
	}
}