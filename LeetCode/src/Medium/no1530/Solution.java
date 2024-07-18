package Medium.no1530;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int countPairs(TreeNode root, int distance) {

		updateValueToDepth(root, 0);
		return getAnswer(root, distance);

	}

	private int getAnswer(TreeNode node, int distance) {
		int ans = 0;
		if (node != null) {
			if (node.left != null && node.right != null) {
				for (TreeNode left : getLeafChildren(node.left)) {
					for (TreeNode right : getLeafChildren(node.right)) {
						if (left.val + right.val - 2 * node.val <= distance) {
							ans++;
						}
					}
				}
			}
			ans += getAnswer(node.left, distance) + getAnswer(node.right, distance);
		}
		return ans;
	}

	private void updateValueToDepth(TreeNode node, int depth) {
		if (node != null) {
			node.val = depth;
			updateValueToDepth(node.left, depth + 1);
			updateValueToDepth(node.right, depth + 1);
		}
	}

	private List<TreeNode> getLeafChildren(TreeNode node) {
		return getLeafChildren(node, new ArrayList<>());
	}

	private List<TreeNode> getLeafChildren(TreeNode node, List<TreeNode> list) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				list.add(node);
			} else {
				getLeafChildren(node.left, list);
				getLeafChildren(node.right, list);
			}
		}
		return list;
	}
}