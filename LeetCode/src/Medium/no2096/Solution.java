package Medium.no2096;

import java.util.ArrayDeque;

class Solution {
	public String getDirections(TreeNode root, int startValue, int destValue) {
		ArrayDeque[] arr = new ArrayDeque[2];
		dfs(root, new ArrayDeque<>(), startValue, destValue, arr);

		StringBuilder sb = new StringBuilder();
		ArrayDeque<Character> st = arr[0], ed = arr[1];
		while (!st.isEmpty() && !ed.isEmpty() && st.peekFirst() == ed.peekFirst()) {
			st.pollFirst();
			ed.pollFirst();
		}

		while (!st.isEmpty()) {
			sb.append('U');
			st.pollFirst();
		}

		while (!ed.isEmpty()) {
			sb.append(ed.pollFirst());
		}

		return sb.toString();
	}

	private void dfs(TreeNode node, ArrayDeque<Character> str, int startValue, int destValue, ArrayDeque[] arr) {
		if (node == null)
			return;
		if (node.val == startValue)
			arr[0] = str.clone();
		if (node.val == destValue)
			arr[1] = str.clone();

		str.add('L');
		dfs(node.left, str, startValue, destValue, arr);
		str.pollLast();

		str.add('R');
		dfs(node.right, str, startValue, destValue, arr);
		str.pollLast();
	}
}