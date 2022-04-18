package Medium.no230;

import java.util.HashMap;
import java.util.Map;

class Solution {

	public int kthSmallest(TreeNode root, int k) {

		if (root != null) {

			TreeNode next = null;

			if (root.left != null) {

				int cntLeft = countChild(root.left);

				if (cntLeft < k) {
					next = root;
					root.left = null;
					k -= cntLeft;
				} else {
					next = root.left;
				}

			} else {

				if (k == 1)
					return root.val;
				else {
					next = root.right;
					k--;
				}
			}

			return kthSmallest(next, k);

		}

		return 0;
	}

	Map<TreeNode, Integer> counter = new HashMap<>();

	public int countChild(TreeNode node) {

		if (counter.containsKey(node))
			return counter.get(node);

		int cnt = node == null ? 0 : 1;

		if (node != null) {
			cnt += countChild(node.left);
			cnt += countChild(node.right);
		}

		counter.put(node, cnt);

		return cnt;
	}

}