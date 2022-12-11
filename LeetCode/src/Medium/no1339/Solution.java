package Medium.no1339;

import java.util.ArrayList;

class Solution {

	ArrayList<Integer> list = new ArrayList<>();
	static final int MOD = 1000000007;

	public int maxProduct(TreeNode root) {

		int sum = dfs(root);

		long max = Long.MIN_VALUE;

		for (int val : list)
			max = Math.max(max, (long) val * (sum - val));

		return (int) (max % MOD);
	}

	int dfs(TreeNode node) {

		if (node == null)
			return 0;

		int val = node.val + dfs(node.left) + dfs(node.right);
		list.add(val);
		return val;
	}
}