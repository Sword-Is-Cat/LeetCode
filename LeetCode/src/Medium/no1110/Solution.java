package Medium.no1110;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		List<TreeNode> answer = new ArrayList<>();
		boolean[] delete = new boolean[1001];
		for (int del : to_delete) {
			delete[del] = true;
		}
		if (!delete[root.val]) {
			answer.add(root);
		}

		dfs(root, null, ' ', answer, delete);

		return answer;
	}

	private void dfs(TreeNode node, TreeNode parent, char direction, List<TreeNode> answer, boolean[] delete) {
		if (node == null)
			return;

		if (delete[node.val]) {
			if (parent != null) {
				if (direction == 'L') {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			if (node.left != null && !delete[node.left.val]) {
				answer.add(node.left);
			}
			if (node.right != null && !delete[node.right.val]) {
				answer.add(node.right);
			}
		}
		
		dfs(node.left, node, 'L', answer, delete);
		dfs(node.right, node, 'R', answer, delete);
	}

}
