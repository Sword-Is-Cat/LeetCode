package Medium.no1209;

import java.util.Stack;

class Solution {
	public String removeDuplicates(String s, int k) {

		Stack<VO> stack = new Stack<>();

		for (char ch : s.toCharArray()) {

			if (stack.isEmpty() || stack.peek().ch != ch) {
				stack.add(new VO(ch));
			} else {
				if (++stack.peek().cnt == k)
					stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder();

		for (VO vo : stack) {
			while (vo.cnt-- > 0) {
				sb.append(vo.ch);
			}
		}

		return sb.toString();

	}
}

class VO {

	char ch;
	int cnt;

	VO(char ch) {
		this.ch = ch;
		cnt = 1;
	}

}