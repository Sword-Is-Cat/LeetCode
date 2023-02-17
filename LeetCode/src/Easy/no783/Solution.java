package Easy.no783;

import java.util.ArrayList;

class Solution {

	ArrayList<Integer> list;

	public int minDiffInBST(TreeNode root) {

		list = new ArrayList<>();

		appendNode(root);

		int diff = 100000, size = list.size();

		for (int i = 1; i < size; i++) {
			diff = Math.min(diff, list.get(i) - list.get(i - 1));
		}

		return diff;
	}

	protected void appendNode(TreeNode node) {
		if (node != null) {
			appendNode(node.left);
			list.add(node.val);
			appendNode(node.right);
		}
	}
}