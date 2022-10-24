package Medium.no1302;

class Solution {
	public int deepestLeavesSum(TreeNode root) {

		return root == null ? 0 : findDeepestLeaf(root, 0)[1];
	}

	int[] findDeepestLeaf(TreeNode node, int depth) {

		int[] result = { depth, node.val };

		if (node.left != null) {
			int[] leftRst = findDeepestLeaf(node.left, depth + 1);
			if (result[0] < leftRst[0])
				result = leftRst;
			else if (result[0] == leftRst[0])
				result[1] += leftRst[1];
		}

		if (node.right != null) {
			int[] rightRst = findDeepestLeaf(node.right, depth + 1);
			if (result[0] < rightRst[0])
				result = rightRst;
			else if (result[0] == rightRst[0])
				result[1] += rightRst[1];
		}

		return result;
	}
}