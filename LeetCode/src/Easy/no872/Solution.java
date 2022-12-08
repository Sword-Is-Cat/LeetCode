package Easy.no872;

import java.util.ArrayList;

class Solution {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		ArrayList<Integer> list1 = getLeafSequence(root1);
		ArrayList<Integer> list2 = getLeafSequence(root2);

		if (list1.size() != list2.size())
			return false;

		for (int idx = 0; idx < list1.size(); idx++) {
			if (list1.get(idx) != list2.get(idx))
				return false;
		}
		return true;
	}

	ArrayList<Integer> getLeafSequence(TreeNode node) {
		ArrayList<Integer> list = new ArrayList<>();
		dfs(list, node);
		return list;
	}

	void dfs(ArrayList<Integer> list, TreeNode node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			list.add(node.val);
		}
		dfs(list, node.left);
		dfs(list, node.right);
	}
}