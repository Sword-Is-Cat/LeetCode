package Easy.no144;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		query(list, root);
		return list;
	}

	void query(ArrayList<Integer> list, TreeNode node) {
		if (node != null) {
			list.add(node.val);
			query(list, node.left);
			query(list, node.right);
		}
	}
}