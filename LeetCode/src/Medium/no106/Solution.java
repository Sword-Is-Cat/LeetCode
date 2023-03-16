package Medium.no106;

import java.util.HashMap;

class Solution {

	int[] io, po;
	HashMap<Integer, Integer> ioMap;

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		io = inorder;
		po = postorder;
		ioMap = new HashMap<>();
		for (int i = 0; i < io.length; i++)
			ioMap.put(io[i], i);
		int length = io.length;

		return buildNode(0, length - 1, 0, length - 1);
	}

	protected TreeNode buildNode(int ios, int ioe, int pos, int poe) {

		TreeNode node = new TreeNode(po[poe]);
		int index = ioMap.get(node.val);

		if (ios < index)
			node.left = buildNode(ios, index - 1, pos, pos + index - ios - 1);

		if (index < ioe)
			node.right = buildNode(index + 1, ioe, pos + index - ios, poe - 1);

		return node;
	}
}