package Hard.no3203;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
		int dia1 = getDiameter(edges1);
		int dia2 = getDiameter(edges2);
		int mergeDia = (dia1 + 1) / 2 + (dia2 + 1) / 2 + 1;
		return Math.max(mergeDia, Math.max(dia1, dia2));
	}

	private int getDiameter(int[][] edges) {

		if (edges.length == 0)
			return 0;

		int[][] values = new int[edges.length + 1][2];
		List<List<Integer>> conn = new ArrayList<>();
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < values.length; i++) {
			conn.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			conn.get(edge[0]).add(edge[1]);
			conn.get(edge[1]).add(edge[0]);
		}

		for (int i = 0; i < values.length; i++) {
			if (conn.get(i).size() == 1)
				que.offer(i);
		}

		while (que.size() > 1) {
			Integer idx = que.poll();
			int dist = values[idx][0] + 1;
			int next = conn.get(idx).get(0);
			if (values[next][0] < dist) {
				values[next][1] = values[next][0];
				values[next][0] = dist;
			} else if (values[next][1] < dist) {
				values[next][1] = dist;
			}
			conn.get(next).remove(idx);
			if (conn.get(next).size() == 1)
				que.offer(next);
		}

		return values[que.peek()][0] + values[que.peek()][1];
	}

}