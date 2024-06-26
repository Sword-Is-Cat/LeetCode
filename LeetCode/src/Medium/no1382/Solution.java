package Medium.no1382;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		listingBST(list, root);
		return repositionBST(list, 0, list.size());
	}

	private void listingBST(List<TreeNode> list, TreeNode node) {
		if (node == null)
			return;
		listingBST(list, node.left);
		list.add(node);
		listingBST(list, node.right);
	}

	private TreeNode repositionBST(List<TreeNode> list, int from, int to) {
		if (from == to)
			return null;
		int idx = (from + to) / 2;
		TreeNode result = list.get(idx);

		result.left = repositionBST(list, from, idx);
		result.right = repositionBST(list, idx + 1, to);

		return result;
	}
}