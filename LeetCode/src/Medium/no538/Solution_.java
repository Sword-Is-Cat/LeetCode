package Medium.no538;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution_ {
	public TreeNode convertBST(TreeNode root) {

		Map<Integer, TreeNode> nodeMap = new HashMap<>();
		mappingNode(root, nodeMap);

		int sum = 0;

		for (int key : nodeMap.keySet()) {
			sum += key;
		}

		Queue<Integer> que = new PriorityQueue<>(nodeMap.keySet());

		while (!que.isEmpty()) {
			int key = que.poll();
			nodeMap.get(key).val = sum;
			sum -= key;
		}

		return root;
	}

	void mappingNode(TreeNode node, Map<Integer, TreeNode> map) {
		if (node != null) {
			map.put(node.val, node);
			mappingNode(node.left, map);
			mappingNode(node.right, map);
		}
	}
}