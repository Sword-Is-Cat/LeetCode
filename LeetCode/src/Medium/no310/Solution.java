package Medium.no310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
		}

		for (int[] edge : edges) {
			nodes[edge[0]].connect(nodes[edge[1]]);
		}

		int min = n;
		List<Integer> ans = new ArrayList<>();

		if (n <= 2) {
			for (int i = 0; i < n; i++) {
				ans.add(i);
			}
			return ans;
		}

		for (int i = 0; i < n; i++) {
			if (nodes[i].conn.size() == 1)
				continue;
			int leng = nodes[i].getFarthest(nodes[i]);
			if (min > leng) {
				min = leng;
				ans.clear();
			}
			if (min == leng) {
				ans.add(i);
			}
		}

		return ans;
	}
}

class Node {

	List<Node> conn;
	Map<Node, Integer> cache;

	Node() {
		conn = new ArrayList<>();
		cache = new HashMap<>();
	}

	void connect(Node node) {
		this.conn.add(node);
		node.conn.add(this);
	}

	int getFarthest(Node from) {
		if (!cache.containsKey(from)) {
			int length = 0;
			for (Node neighbor : conn) {
				if (!neighbor.equals(from)) {
					length = Math.max(length, neighbor.getFarthest(this) + 1);
				}
			}
			cache.put(from, length);
		}
		return cache.get(from);
	}
}