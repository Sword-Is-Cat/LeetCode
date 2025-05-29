package Hard.no3373;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {

		int[] arr1 = divideNodes(edges1);
		int[] cnt1 = countNum(arr1);
		int[] arr2 = divideNodes(edges2);
		int[] cnt2 = countNum(arr2);
		int max = Math.max(cnt2[1], cnt2[2]);

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = cnt1[arr1[i]] + max;
		}

		return arr1;
	}

	private int[] countNum(int[] arr) {
		int[] result = new int[3];
		for (int num : arr)
			result[num]++;
		return result;
	}

	private int[] divideNodes(int[][] edges) {

		int length = edges.length + 1;
		int[] result = new int[length];

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < length; i++)
			graph.add(new ArrayList<>());

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(0);
		result[0] = 1;

		int mask = 1;

		while (!queue.isEmpty()) {
			int loop = queue.size();
			mask = 3 - mask;
			while (loop-- > 0) {
				int node = queue.poll();
				for (int next : graph.get(node)) {
					if (result[next] == 0) {
						result[next] = mask;
						queue.offer(next);
					}
				}
			}
		}

		return result;
	}
}