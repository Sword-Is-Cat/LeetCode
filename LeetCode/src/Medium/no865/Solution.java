package Medium.no865;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public TreeNode subtreeWithAllDeepest(TreeNode root) {

		HashSet<TreeNode> prev = null, curr = new HashSet<>();
		curr.add(root);
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

		while (curr.size() > 0) {
			prev = curr;
			curr = new HashSet<>();
			for (TreeNode node : prev) {
				if (node.left != null) {
					curr.add(node.left);
					parentMap.put(node.left, node);
				}
				if (node.right != null) {
					curr.add(node.right);
					parentMap.put(node.right, node);
				}
			}
		}

		curr = prev;

		while (curr.size() > 1) {
			prev = curr;
			curr = new HashSet<>();
			for (TreeNode node : prev) {
				curr.add(parentMap.get(node));
			}
		}

		return curr.iterator().next();
	}
}