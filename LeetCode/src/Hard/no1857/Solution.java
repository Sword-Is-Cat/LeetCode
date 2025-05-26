package Hard.no1857;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int largestPathValue(String colors, int[][] edges) {

		int length = colors.length();
		Node[] nodes = new Node[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new Node(colors.charAt(i));
		}

		for (int[] edge : edges) {
			nodes[edge[0]].conn.add(nodes[edge[1]]);
			nodes[edge[1]].receive++;
		}

		Queue<Node> queue = new ArrayDeque<>();
		for (int i = 0; i < length; i++) {
			if (nodes[i].receive == 0)
				queue.offer(nodes[i]);
		}

		int answer = 0, visit = 0;

		while (!queue.isEmpty()) {

			Node node = queue.poll();
			visit++;
			answer = Math.max(answer, ++node.maxColor[node.color]);

			for (Node next : node.conn) {
				next.mergeColorCount(node.maxColor);
				if (--next.receive == 0)
					queue.offer(next);
			}
		}

		return visit == length ? answer : -1;
	}
}

class Node {
	int color;
	List<Node> conn;
	int receive;
	int[] maxColor;

	Node(char ch) {
		color = ch - 'a';
		conn = new ArrayList<>();
		receive = 0;
		maxColor = new int[26];
	}

	public void mergeColorCount(int[] colors) {
		for (int i = 0; i < maxColor.length; i++) {
			maxColor[i] = Math.max(maxColor[i], colors[i]);
		}
	}
}