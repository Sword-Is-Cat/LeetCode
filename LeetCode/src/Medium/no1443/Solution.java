package Medium.no1443;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

		Node[] nodes = new Node[n];

		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(hasApple.get(i));
		}

		for (int[] edge : edges) {
			nodes[edge[0]].children.add(nodes[edge[1]]);
			nodes[edge[1]].children.add(nodes[edge[0]]);
		}

		Node root = nodes[0];
		root.removeParent(null);

		return dfs(root)[1];
	}

	int[] dfs(Node node) {

		if (node == null)
			return new int[] { 0, 0 };

		int apple = node.hasApple ? 1 : 0, move = 0;

		for (Node child : node.children) {

			int[] result = dfs(child);
			apple = Math.max(apple, result[0]);
			move += result[0] * (result[1] + 2);

		}

		return new int[] { apple, move };
	}

}

class Node {

	boolean hasApple;
	ArrayList<Node> children;

	Node(boolean apple) {
		this.hasApple = apple;
		this.children = new ArrayList<>();
	}

	void removeParent(Node parent) {
		if (parent != null)
			this.children.remove(parent);
		for (Node child : this.children)
			child.removeParent(this);
	}

}