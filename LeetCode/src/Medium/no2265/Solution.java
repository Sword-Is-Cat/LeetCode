package Medium.no2265;

class Solution {

	public int averageOfSubtree(TreeNode root) {
		return dfs(root)[2];
	}

	private int[] dfs(TreeNode node) {

		int[] result = new int[3]; // {count, sum, answer}

		if (node != null) {

			int[] lres = dfs(node.left);
			int[] rres = dfs(node.right);

			result[0] = lres[0] + rres[0];
			result[1] = lres[1] + rres[1];
			result[2] = lres[2] + rres[2];

			result[0]++;
			result[1] += node.val;
			if (node.val == result[1] / result[0]) {
				result[2]++;
			}
		}
		return result;
	}
}