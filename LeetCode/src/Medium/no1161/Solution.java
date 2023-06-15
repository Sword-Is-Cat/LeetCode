package Medium.no1161;

import java.util.ArrayDeque;

class Solution {
	public int maxLevelSum(TreeNode root) {

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		que.addLast(root);

		int ans = 0, max = -10001;

		for (int level = 1; !que.isEmpty(); level++) {

			int sum = 0, cnt = que.size();

			while (cnt-- > 0) {
				TreeNode node = que.pollFirst();
				sum += node.val;
				if (node.left != null) que.addLast(node.left);
				if (node.right != null) que.addLast(node.right);
			}
			
			if(max<sum) {
				max = sum;
				ans = level;
			}

		}

		return ans;
	}
}