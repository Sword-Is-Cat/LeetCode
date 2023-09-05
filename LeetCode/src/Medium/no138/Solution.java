package Medium.no138;

import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<Node, Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {

		return getCopyNode(head);
	}

	private Node getCopyNode(Node node) {
		if (node == null)
			return null;
		if (!map.containsKey(node)) {
			Node newNode = new Node(node.val);
			map.put(node, newNode);
			newNode.next = getCopyNode(node.next);
			newNode.random = getCopyNode(node.random);
		}
		return map.get(node);
	}
}