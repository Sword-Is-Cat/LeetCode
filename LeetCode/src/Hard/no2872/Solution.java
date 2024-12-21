package Hard.no2872;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

		Node[] arr = new Node[n];
		Queue<Node> que = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			arr[i] = new Node(i, values[i] % k);
			que.offer(arr[i]);
		}

		for (int[] edge : edges) {
			arr[edge[0]].list.add(arr[edge[1]]);
			arr[edge[1]].list.add(arr[edge[0]]);
		}

		int answer = 1;

		while (que.size() > 1) {
			Node node = que.poll();
			if (node.list.size() == 1) {
				Node conn = node.list.get(0);
				conn.list.remove(node);
				if (node.value == 0) {
					answer++;
				} else {
					conn.value = (conn.value + node.value) % k;
				}
			} else {
				que.offer(node);
			}
		}

		return answer;
	}
}

class Node {

	int idx, value;
	List<Node> list;

	Node(int idx, int value) {
		this.idx = idx;
		this.value = value;
		list = new ArrayList<>();
	}
}