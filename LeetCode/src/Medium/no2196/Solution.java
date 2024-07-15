package Medium.no2196;

class Solution {
	public TreeNode createBinaryTree(int[][] descriptions) {

		TreeNode[] nodes = new TreeNode[100001];
		boolean[] isChild = new boolean[100001];

		for (int[] info : descriptions) {

			if (nodes[info[0]] == null)
				nodes[info[0]] = new TreeNode(info[0]);
			if (nodes[info[1]] == null)
				nodes[info[1]] = new TreeNode(info[1]);

			if (info[2] == 1) {
				nodes[info[0]].left = nodes[info[1]];
			} else {
				nodes[info[0]].right = nodes[info[1]];
			}

			isChild[info[1]] = true;

		}

		TreeNode root = null;

		for (int i = 0; root == null && i < nodes.length; i++) {
			if (nodes[i] != null && !isChild[i])
				root = nodes[i];
		}

		return root;
	}
}