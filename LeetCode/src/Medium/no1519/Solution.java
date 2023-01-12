package Medium.no1519;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

	public int[] countSubTrees(int n, int[][] edges, String labels) {

		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(labels.charAt(i));
		}

		for (int[] edge : edges) {
			nodes[edge[0]].conn.add(nodes[edge[1]]);
			nodes[edge[1]].conn.add(nodes[edge[0]]);
		}
		nodes[0].removeParent(null);

		return Arrays.stream(nodes).mapToInt(node -> node.cntMySubs()).toArray();
	}
}

class Node {

	int index;
	ArrayList<Node> conn;
	int[] cache;

	Node(char label) {
		this.index = label - 'a';
		this.conn = new ArrayList<>();
	}

	void removeParent(Node parent) {
		if (conn.contains(parent))
			conn.remove(parent);
		for (Node child : conn) {
			child.removeParent(this);
		}
	}

	int cntMySubs() {
		return cntAllSubs()[index];
	}

	int[] cntAllSubs() {
		if (cache == null) {
			cache = new int[26];
			cache[index] = 1;
			for (Node child : conn) {
				int[] temp = child.cntAllSubs();
				for (int i = 0; i < 26; i++) {
					cache[i] += temp[i];
				}
			}
		}
		return cache;
	}
}