package Medium.no2385;

class Solution {

	int ans = 0;

	public int amountOfTime(TreeNode root, int start) {

		dfs(root, start);
		return ans;
	}

	private int dfs(TreeNode node, int start) {

		if (node == null)
			return 0;

		int depthL = dfs(node.left, start);
		int depthR = dfs(node.right, start);

		if (node.val == start) {
			// 현재 노드가 감염원 인 경우
			ans = Math.max(depthL, depthR);
			return -1;
		} else if (0 <= depthL && 0 <= depthR) {
			// 현재 노드와 그 하위노드에 감염원이 없는 경우
			return Math.max(depthL, depthR) + 1;
		} else {
			// 현재 노드의 하위노드에 감염원이 있는 경우
			ans = Math.max(ans, Math.abs(depthL - depthR));
			return Math.min(depthL, depthR) - 1;
		}

	}
}