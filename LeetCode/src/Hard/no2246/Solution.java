package Hard.no2246;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

	int max = 0;

	public int longestPath(int[] parent, String s) {

		char[] chArr = s.toCharArray();

		Node[] nodes = new Node[chArr.length];
		for (int i = 0; i < chArr.length; i++) {
			nodes[i] = new Node(i, chArr[i]);
		}

		for (int i = 1; i < parent.length; i++) {
			nodes[parent[i]].conn.add(nodes[i]);
		}

		dfs(nodes[0]);

		return max;
	}

	void dfs(Node node) {

		int[] arr = node.conn.stream().mapToInt(child -> child.longestPath(node.value)).toArray();
		Arrays.sort(arr);

		int leng = arr.length == 0 ? 0 : arr.length == 1 ? arr[0] : (arr[arr.length - 1] + arr[arr.length - 2]);

		for (Node child : node.conn)
			dfs(child);

		max = Math.max(max, leng + 1);
	}

}

class Node {

	int index;
	char value;
	ArrayList<Node> conn;

	Node(int index, char value) {
		this.index = index;
		this.value = value;
		this.conn = new ArrayList<>();
	}

	int cache = -1;

	int longestPath(char ptVal) {

		if (this.value == ptVal)
			return 0;

		if (cache == -1) {
			int maxVal = 0;
			for (Node child : conn)
				maxVal = Math.max(maxVal, child.longestPath(this.value));
			cache = maxVal + 1;
		}
		return cache;
	}
}