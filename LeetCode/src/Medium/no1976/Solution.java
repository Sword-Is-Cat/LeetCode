package Medium.no1976;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	public int countPaths(int n, int[][] roads) {

		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] road : roads) {
			graph.get(road[0]).add(new int[] { road[1], road[2] });
			graph.get(road[1]).add(new int[] { road[0], road[2] });
		}

		long[] dist = new long[n];
		int[] ways = new int[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;
		ways[0] = 1;

		PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
		queue.offer(new long[] { 0, 0 });

		int MOD = (int) 1e9 + 7;

		while (!queue.isEmpty()) {

			long[] curr = queue.poll();
			long d = curr[0];
			int node = (int) curr[1];

			if (d > dist[node]) {
				continue;
			}

			for (int[] neighbor : graph.get(node)) {
				
				int nextNode = neighbor[0];
				int time = neighbor[1];

				if (dist[node] + time < dist[nextNode]) {
					
					dist[nextNode] = dist[node] + time;
					ways[nextNode] = ways[node];
					queue.offer(new long[] { dist[nextNode], nextNode });
					
				} else if (dist[node] + time == dist[nextNode]) {
					ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
				}
			}
		}

		return ways[n - 1];
	}
}