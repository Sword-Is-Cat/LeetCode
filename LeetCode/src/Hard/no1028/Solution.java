package Hard.no1028;

import java.util.Stack;

class Solution {

	char[] arr;
	int idx;

	public TreeNode recoverFromPreorder(String traversal) {

		arr = traversal.toCharArray();
		idx = 0;
		Stack<TreeNode> stack = new Stack<>();

		while (hasNext()) {
			int[] info = getNextInfo();
			int depth = info[0];
			TreeNode node = new TreeNode(info[1]);
			while (stack.size() > depth) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				if (stack.peek().left == null) {
					stack.peek().left = node;
				} else {
					stack.peek().right = node;
				}
			}
			stack.push(node);
		}

		while (stack.size() > 1) {
			stack.pop();
		}

		return stack.pop();
	}

	private boolean hasNext() {
		return idx < arr.length;
	}

	private int[] getNextInfo() {
		int[] info = new int[2];
		while (info[1] == 0 || (hasNext() && Character.isDigit(arr[idx]))) {
			if (Character.isDigit(arr[idx])) {
				info[1] *= 10;
				info[1] += arr[idx] - '0';
			} else {
				info[0]++;
			}
			idx++;
		}
		return info;
	}
}