package Medium.no1514;

class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

		double[] probs = new double[n];
		probs[start_node] = 1D;

		boolean update = true;

		while (update) {
			update = false;
			for (int i = 0; i < edges.length; i++) {
				int[] edge = edges[i];
				if (probs[edge[0]] * succProb[i] > probs[edge[1]]) {
					probs[edge[1]] = probs[edge[0]] * succProb[i];
					update = true;
				}
				if (probs[edge[1]] * succProb[i] > probs[edge[0]]) {
					probs[edge[0]] = probs[edge[1]] * succProb[i];
					update = true;
				}
			}
		}

		return probs[end_node];
	}
}