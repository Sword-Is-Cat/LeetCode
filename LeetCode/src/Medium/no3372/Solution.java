package Medium.no3372;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {

		int[] array1 = getArrayOfConnect(edges1, k);
		int[] array2 = getArrayOfConnect(edges2, k - 1);
		int max = array2[0];
		for (int num : array2)
			max = Math.max(max, num);

		for (int i = 0; i < array1.length; i++)
			array1[i] += max;

		return array1;
	}

	private int[] getArrayOfConnect(int[][] edges, int k) {
		int length = edges.length + 1;
		int[] result = new int[length];
		if (k > -1) {
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < length; i++)
				graph.add(new ArrayList<>());
			for (int[] edge : edges) {
				graph.get(edge[0]).add(edge[1]);
				graph.get(edge[1]).add(edge[0]);
			}
			for (int i = 0; i < length; i++)
				result[i] = getConnectCount(graph, k, i);
		}
		return result;
	}

	private int getConnectCount(List<List<Integer>> graph, int k, int init) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[graph.size()];
		queue.offer(init);
		visit[init] = true;
		int result = 1;
		while (k-- > 0) {
			int loop = queue.size();
			while (loop-- > 0) {
				int node = queue.poll();
				for (int next : graph.get(node)) {
					if (!visit[next]) {
						visit[next] = true;
						queue.offer(next);
						result++;
					}
				}
			}
		}
		return result;
	}

}