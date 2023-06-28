package Medium.no1514;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

		HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();
		double[] probs = new double[n];

		for (int i = 0; i < edges.length; i++) {
			map.computeIfAbsent(edges[i][0], v -> new HashMap<>()).put(edges[i][1], succProb[i]);
			map.computeIfAbsent(edges[i][1], v -> new HashMap<>()).put(edges[i][0], succProb[i]);
		}
		probs[start] = 1D;

		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Double.compare(probs[b], probs[a]));
		queue.add(start);

		while (!queue.isEmpty()) {

			int point = queue.poll();

			if (!map.containsKey(point))
				continue;

			for (int next : map.get(point).keySet()) {

				double newProb = probs[point] * map.get(point).get(next);

				if (probs[next] < newProb) {
					probs[next] = newProb;
					queue.add(next);
				}

			}

		}

		return probs[end];
	}
}