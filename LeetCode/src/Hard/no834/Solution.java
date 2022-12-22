package Hard.no834;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

	public int[] sumOfDistancesInTree(int n, int[][] edges) {

		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}

		for (int[] edge : edges) {
			nodes[edge[0]].addConn(nodes[edge[1]]);
		}

		int[] ans = new int[n];

		for (int i = 0; i < n; i++)
			ans[i] = getInfo(nodes[i], null)[1];

		return ans;
	}

	int[] getInfo(Node node, Node caller) {

		if (caller != null && node.cache.containsKey(caller))
			return node.cache.get(caller);

		int cntDesc = 0, sumDist = 0;

		for (Node child : node.conn) {
			if (child != caller) {
				int[] info = getInfo(child, node);
				cntDesc += info[0] + 1;
				sumDist += info[1] + info[0] + 1;
			}
		}

		int[] result = new int[] { cntDesc, sumDist };
		if (caller != null)
			node.cache.put(caller, result);

		return result;

	}

}

class Node {

	final int index;
	ArrayList<Node> conn;
	HashMap<Node, int[]> cache;

	Node(int i) {
		this.index = i;
		this.conn = new ArrayList<>();
		this.cache = new HashMap<>();
	}

	void addConn(Node node) {
		if (node != null) {
			this.conn.add(node);
			node.conn.add(this);
		}
	}
}