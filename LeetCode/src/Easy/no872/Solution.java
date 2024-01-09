package Easy.no872;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		List<Integer> list1 = getLeafSequence(root1);
		List<Integer> list2 = getLeafSequence(root2);

		boolean answer = list1.size() == list2.size();

		for (int idx = 0; answer && idx < list1.size(); idx++) {
			answer &= list1.get(idx) == list2.get(idx);
		}

		return answer;
	}

	private List<Integer> getLeafSequence(TreeNode root) {

		return dfs(root, new ArrayList<>());
	}

	private List<Integer> dfs(TreeNode node, List<Integer> container) {

		if (node != null) {

			dfs(node.left, container);

			if (node.left == null && node.right == null)
				container.add(node.val);

			dfs(node.right, container);

		}

		return container;
	}

}