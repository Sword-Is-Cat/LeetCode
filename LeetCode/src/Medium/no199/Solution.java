package Medium.no199;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		process(list, root, 0);

		return list;
	}

	void process(List<Integer> list, TreeNode node, int depth) {

		if(node == null) return;
		
		if (depth == list.size()) {
			list.add(node.val);
		}
		process(list, node.right, depth + 1);
		process(list, node.left, depth + 1);

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}