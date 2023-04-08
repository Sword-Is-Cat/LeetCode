package Medium.no133;

class Solution {

	Node[] array = new Node[101];

	public Node cloneGraph(Node node) {

		if (node == null)
			return null;

		if (array[node.val] == null) {

			Node newNode = new Node(node.val);
			array[node.val] = newNode;

			for (Node neighbor : node.neighbors) {
				newNode.neighbors.add(cloneGraph(neighbor));
			}
		}
		return array[node.val];
	}
}