package Medium.no652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	HashMap<String, Integer> counter = new HashMap<>();
	ArrayList<TreeNode> ans = new ArrayList<>();
	char separator = '|';

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		stringify(root);

		return ans;
	}

	protected String stringify(TreeNode node) {

		if (node == null)
			return "NULL";

		String nodeKey = 
				new StringBuilder().append(node.val)
				.append(separator).append(stringify(node.left))
				.append(separator).append(stringify(node.right)).toString();

		counter.compute(nodeKey, (k, v) -> v == null ? 1 : (v + 1));
		if (counter.get(nodeKey) == 2)
			ans.add(node);

		return nodeKey;
	}
}