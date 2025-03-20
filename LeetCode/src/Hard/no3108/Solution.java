package Hard.no3108;

import java.util.HashMap;

class Solution {

	int[] uf;

	public int[] minimumCost(int n, int[][] edges, int[][] query) {

		uf = new int[n];
		for (int i = 0; i < n; i++) {
			uf[i] = i;
		}
		
		for (int[] edge : edges) {
			setUF(edge[0], edge[1]);
		}

		HashMap<Integer, Integer> minDist = new HashMap<>();
		for (int[] edge : edges) {
			int u = getUF(edge[0]);
			minDist.put(u, minDist.getOrDefault(u, Integer.MAX_VALUE) & edge[2]);
		}

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			int ufa = getUF(query[i][0]), ufb = getUF(query[i][1]);
			answer[i] = ufa == ufb ? minDist.get(ufa) : -1;
		}

		return answer;
	}

	private int getUF(int a) {
		int ufa = uf[a];
		if (ufa != a) {
			uf[a] = getUF(ufa);
		}
		return uf[a];
	}

	private void setUF(int a, int b) {
		int ufa = getUF(a), ufb = getUF(b);
		uf[ufa] = uf[ufb];
	}
}