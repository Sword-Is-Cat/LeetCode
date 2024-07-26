package Medium.no1334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {

		List<List<int[]>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int city1 = edge[0], city2 = edge[1], weight = edge[2];
			graph.get(city1).add(new int[] { city2, weight });
			graph.get(city2).add(new int[] { city1, weight });
		}

		int ans = -1, cnt = n;

		for (int i = 0; i < n; i++) {
			int rst = countNeibors(n, i, graph, distanceThreshold);
			if (rst <= cnt) {
				ans = i;
				cnt = rst;
			}
		}

		return ans;
	}

	private int countNeibors(int n, int city, List<List<int[]>> graph, int distanceThreshold) {

		int[] dist = new int[n];
		Arrays.fill(dist, 10000000);
		dist[city] = 0;

		dfs(city, dist, graph, distanceThreshold);

		int rst = 0;
		for (int d : dist) {
			if (d < 10000000) {
				rst++;
			}
		}

		return rst;
	}

	private void dfs(int from, int[] dist, List<List<int[]>> graph, int distanceThreshold) {

		int currDist = dist[from];
		for (int[] conn : graph.get(from)) {
			if (currDist + conn[1] < dist[conn[0]] && currDist + conn[1] <= distanceThreshold) {
				dist[conn[0]] = currDist + conn[1];
				dfs(conn[0], dist, graph, distanceThreshold);
			}
		}

	}
}