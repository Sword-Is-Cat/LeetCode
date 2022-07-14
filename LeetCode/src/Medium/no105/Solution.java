package Medium.no105;

import java.util.HashMap;

class Solution {

	HashMap<Integer, TreeNode> valNode;
	HashMap<TreeNode, Integer> inIdx;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		valNode = new HashMap<>();
		inIdx = new HashMap<>();

		for (int idx = 0; idx < inorder.length; idx++) {
			int val = inorder[idx];
			TreeNode node = new TreeNode(val);
			valNode.put(val, node);
			inIdx.put(node, idx);
		}

		TreeNode root = valNode.get(preorder[0]);

		for (int val : preorder)
			addChild(root, valNode.get(val), inIdx);

		return root;
	}

	void addChild(TreeNode parent, TreeNode node, HashMap<TreeNode, Integer> inIdx) {

		int ptIdx = inIdx.get(parent), chIdx = inIdx.get(node);

		if (ptIdx < chIdx) {
			// right
			if (parent.right == null)
				parent.right = node;
			else
				addChild(parent.right, node, inIdx);
		} else if (chIdx < ptIdx) {
			// left
			if (parent.left == null)
				parent.left = node;
			else
				addChild(parent.left, node, inIdx);
		}
	}
}