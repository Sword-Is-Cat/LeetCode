package Medium.no3243;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

		Node[] arr = new Node[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Node(i);
			if (i > 0) {
				arr[i - 1].addConnect(arr[i]);
			}
		}

		int[] answer = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			arr[query[0]].addConnect(arr[query[1]]);
			arr[query[1]].update(arr[query[0]].getDistance() + 1);
			answer[i] = arr[n - 1].getDistance();
		}

		return answer;
	}
}

class Node {

	private int distance;
	private List<Node> connect;

	Node(int i) {
		this.distance = i;
		connect = new ArrayList<>();
	}

	protected void addConnect(Node node) {
		this.connect.add(node);
	}

	protected void update(int newDistance) {
		if (this.distance > newDistance) {
			this.distance = newDistance;
			for (Node node : connect) {
				node.update(this.distance + 1);
			}
		}
	}

	protected int getDistance() {
		return this.distance;
	}
}