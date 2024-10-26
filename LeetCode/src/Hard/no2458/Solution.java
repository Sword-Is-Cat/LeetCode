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

		if (node.left != null) {
			removeHeights[node.left.val] = Math.max(removeHeights[node.val],
					node.right == null ? depth : existHeights[node.right.val]);
			calcRemoved(removeHeights, existHeights, node.left, depth + 1);
		}
		if (node.right != null) {
			removeHeights[node.right.val] = Math.max(removeHeights[node.val],
					node.left == null ? depth : existHeights[node.left.val]);
			calcRemoved(removeHeights, existHeights, node.right, depth + 1);
		}

	}

}