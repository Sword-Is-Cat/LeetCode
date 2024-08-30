package Hard.no2699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

		List<Map<Integer, int[]>> graph = new ArrayList<>();
		List<int[]> undifined = new ArrayList<>();
		for (int i = 0; i < n; i++)
			graph.add(new HashMap<>());

		for (int[] edge : edges) {
			if (edge[2] == -1) {
				undifined.add(edge);
			} else {
				graph.get(edge[0]).put(edge[1], edge);
				graph.get(edge[1]).put(edge[0], edge);
			}
		}

		int dist = distanceToDestination(n, graph, source, destination, target);

		if (dist < target)
			return new int[0][]; // already shorter than target

		boolean reachable = dist == target;

		for (int[] edge : undifined) {

			if (reachable) {
				edge[2] = target;
			} else {
				graph.get(edge[0]).put(edge[1], edge);
				graph.get(edge[1]).put(edge[0], edge);
				edge[2] = 1;
				dist = distanceToDestination(n, graph, source, destination, target);
				if (dist <= target) {
					reachable = true;
					edge[2] += target - dist;
				}
			}
		}

		return reachable ? edges : new int[0][];
	}

	private int distanceToDestination(int n, List<Map<Integer, int[]>> graph, int source, int destination, int target) {
		int[] dist = new int[n];
		Arrays.fill(dist, target + 1);
		dist[source] = 0;
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(dist[a], dist[b]));
		queue.add(source);

		while (!queue.isEmpty()) {
			int point = queue.poll();
			for (int next : graph.get(point).keySet()) {
				int newDist = dist[point] + graph.get(point).get(next)[2];
				if (dist[next] > newDist) {
					dist[next] = newDist;
					queue.add(next);
				}
			}
		}
		return dist[destination];
	}

}