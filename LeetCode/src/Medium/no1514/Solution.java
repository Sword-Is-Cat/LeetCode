package Medium.no1514;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

		// edges, succProb의 graph화
		List<Map<Integer, Double>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new HashMap<>());
		}
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).put(edges[i][1], succProb[i]);
			graph.get(edges[i][1]).put(edges[i][0], succProb[i]);
		}
		
		// 도착확률배열 probs선언 및 초기화
		double[] probs = new double[n];
		probs[start] = 1D;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);

		while (!queue.isEmpty()) {

			int point = queue.poll();

			for (int next : graph.get(point).keySet()) {

				double newProb = probs[point] * graph.get(point).get(next);

				if (probs[next] < newProb) {
					probs[next] = newProb;
					queue.add(next);
				}
			}
		}

		return probs[end];
	}
}