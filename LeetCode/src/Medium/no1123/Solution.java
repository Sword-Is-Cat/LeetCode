package Medium.no1123;

import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<TreeNode, Integer> depthMap = new HashMap<>();

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		int leftDepth = nodeDepth(root.left), rightDepth = nodeDepth(root.right);
		if (leftDepth == rightDepth)
			return root;
		else if (leftDepth > rightDepth)
			return lcaDeepestLeaves(root.left);
		else
			return lcaDeepestLeaves(root.right);
	}

	private int nodeDepth(TreeNode node) {
		if (node == null)
			return 0;
		if (!depthMap.containsKey(node)) {
			depthMap.put(node, Math.max(nodeDepth(node.left), nodeDepth(node.right)) + 1);
		}
		return depthMap.get(node);
	}

}