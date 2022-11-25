package Medium.no133;

import java.util.HashMap;

class Solution {

	HashMap<Node, Node> nodeMap = new HashMap<>();

	public Node cloneGraph(Node node) {

		if (node == null)
			return null;

		if (!nodeMap.containsKey(node)) {

			Node newNode = new Node(node.val);
			nodeMap.put(node, newNode);

			for (Node neighbor : node.neighbors) {
				newNode.neighbors.add(cloneGraph(neighbor));
			}
		}
		return nodeMap.get(node);
	}
}