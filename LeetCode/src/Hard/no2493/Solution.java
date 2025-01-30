package Hard.no2493;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int magnificentSets(int n, int[][] edges) {

		// 연결상태 graph화
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0] - 1).add(edge[1] - 1);
			graph.get(edge[1] - 1).add(edge[0] - 1);
		}

		// 유효성 확인
		int[] colors = new int[n];
		int color = 1;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (colors[i] == 0) {
				queue.offer(i);
				while (!queue.isEmpty()) {
					int loop = queue.size();
					while (loop-- > 0) {
						int curr = queue.poll();
						colors[curr] = color;
						for (int next : graph.get(curr)) {
							if (colors[next] == color)
								return -1;
							else if (colors[next] == 0)
								queue.offer(next);
						}
					}
					color *= -1;
				}
			}
		}

		// 각 노드의 최대그룹수 확인
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = calcDistance(graph, i, n);
		}

		// 각 그룹별 최대 값 추출하여 합산
		int ans = 0;
		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				ans += getMaxGroupValue(graph, dist, visit, i);
			}
		}

		return ans;
	}

	private int getMaxGroupValue(List<List<Integer>> graph, int[] dist, boolean[] visit, int curr) {

		visit[curr] = true;
		int result = dist[curr];

		for (int next : graph.get(curr)) {
			if (!visit[next]) {
				result = Math.max(result, getMaxGroupValue(graph, dist, visit, next));
			}
		}

		return result;
	}

	private int calcDistance(List<List<Integer>> graph, int i, int n) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n];
		int distance = 0;

		visit[i] = true;
		queue.offer(i);

		while (!queue.isEmpty()) {
			distance++;
			int loop = queue.size();
			while (loop-- > 0) {
				int curr = queue.poll();
				for (int next : graph.get(curr)) {
					if (!visit[next]) {
						visit[next] = true;
						queue.offer(next);
					}
				}
			}
		}

		return distance;
	}

}