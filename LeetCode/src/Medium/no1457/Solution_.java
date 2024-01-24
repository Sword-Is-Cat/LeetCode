package Medium.no1457;

class Solution_ {
	public int pseudoPalindromicPaths(TreeNode root) {
		return dfs(root, new int[10]);
	}

	int dfs(TreeNode node, int[] counter) {

		int rst = 0;

		if (node != null) {

			counter[node.val]++;
			
			if (node.left == null && node.right == null) {
				
				int cntOdd = 0;
				for (int count : counter) {
					if (count % 2 == 1)
						cntOdd++;
				}
				rst = cntOdd < 2 ? 1 : 0;
				
			} else {
				
				rst += dfs(node.left, counter);
				rst += dfs(node.right, counter);
			}
			
			counter[node.val]--;
		}

		return rst;
	}
}