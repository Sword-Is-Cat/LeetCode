package Medium.no22;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<String> list;
	StringBuilder sb;
	int target;

	public List<String> generateParenthesis(int n) {

		list = new ArrayList<>();
		sb = new StringBuilder();
		target = n;

		process(0, 0);

		return list;
	}

	void process(int i, int j) {

		if (i == target && j == target) {
			list.add(sb.toString());
			return;
		}

		if (i < target) {
			sb.append('(');
			process(i + 1, j);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (i > j) {
			sb.append(')');
			process(i, j + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}