package Medium.no921;

class Solution {
	public int minAddToMakeValid(String s) {

		int add = 0, stack = 0;

		for (char ch : s.toCharArray()) {
			stack += ch == '(' ? 1 : -1;
			if (stack < 0) {
				add++;
				stack++;
			}
		}

		return add + stack;

	}
}