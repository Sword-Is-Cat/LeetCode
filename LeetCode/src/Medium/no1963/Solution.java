package Medium.no1963;

class Solution {
	public int minSwaps(String s) {
		int stack = 0;
		for (char ch : s.toCharArray()) {
			stack += ch == '[' ? 1 : -1;
			if (stack < 0) {
				stack += 2;
			}
		}
		return stack / 2;
	}
}