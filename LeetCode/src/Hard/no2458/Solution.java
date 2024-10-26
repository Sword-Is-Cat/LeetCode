package Hard.no2458;

class Solution {
	public int[] treeQueries(TreeNode root, int[] queries) {

		int[] existHeights = new int[100001];
		calcExist(existHeights, -1, root);

		int[] removeHeights = new int[100001];
		removeHeights[root.val] = -1;
		calcRemoved(removeHeights, existHeights, root, 0);

		for (int i = 0; i < queries.length; i++) {
			queries[i] = removeHeights[queries[i]];
		}

		return queries;
	}

	private int calcExist(int[] existHeights, int currentHeight, TreeNode node) {
		if (node == null)
			return currentHeight;
		existHeights[node.val] = Math.max(calcExist(existHeights, currentHeight + 1, node.left),
				calcExist(existHeights, currentHeight + 1, node.right));
		return existHeights[node.val];
	}

	private void calcRemoved(int[] removeHeights, int[] existHeights, TreeNode node, int depth) {

		int left = node.left == null ? 0 : node.left.val, right = node.right == null ? 0 : node.right.val;

		if (node.left != null) {
			removeHeights[left] = Math.max(removeHeights[node.val], right == 0 ? depth : existHeights[right]);
			calcRemoved(removeHeights, existHeights, node.left, depth + 1);
		}
		if (node.right != null) {
			removeHeights[right] = Math.max(removeHeights[node.val], left == 0 ? depth : existHeights[left]);
			calcRemoved(removeHeights, existHeights, node.right, depth + 1);
		}

	}

}