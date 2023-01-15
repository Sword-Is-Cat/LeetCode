package Hard.no2421;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

	int[] uf;

	public int numberOfGoodPaths(int[] vals, int[][] edges) {

		initializeUnion(vals.length);
		boolean[] connect = new boolean[vals.length];

		Node[] nodes = new Node[vals.length];
		PriorityQueue<Node> que = new PriorityQueue<>((a, b) -> a.value - b.value);
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i, vals[i]);
			que.add(nodes[i]);
		}

		for (int[] edge : edges) {
			nodes[edge[0]].conn.add(nodes[edge[1]]);
			nodes[edge[1]].conn.add(nodes[edge[0]]);
		}

		int ans = 0;

		while (!que.isEmpty()) {

			int val = que.peek().value;
			ArrayList<Node> list = new ArrayList<>();

			while (!que.isEmpty() && que.peek().value == val) {

				Node node = que.poll();
				list.add(node);
				connect[node.index] = true;
				for (Node child : node.conn) {
					if (connect[child.index]) {
						setUnion(node.index, child.index);
					}
				}
			}

			HashMap<Integer, Integer> counter = new HashMap<>();
			for (Node node : list) {
				counter.compute(getUnion(node.index), (k, v) -> v == null ? 1 : v + 1);
			}
			for (int key : counter.keySet()) {
				int value = counter.get(key);
				ans += value * (value + 1) / 2;
			}

		}

		return ans;
	}

	void initializeUnion(int length) {
		uf = new int[length];
		for (int i = 0; i < length; i++)
			uf[i] = i;
	}

	void setUnion(int index1, int index2) {
		int un1 = getUnion(index1), un2 = getUnion(index2);
		if (un1 < un2)
			uf[un2] = un1;
		else if (un1 > un2)
			uf[un1] = un2;
	}

	int getUnion(int index) {
		return uf[index] == index ? index : (uf[index] = getUnion(uf[index]));
	}

}

class Node {

	int index;
	int value;
	ArrayList<Node> conn;

	Node(int index, int value) {
		this.index = index;
		this.value = value;
		conn = new ArrayList<>();
	}
}