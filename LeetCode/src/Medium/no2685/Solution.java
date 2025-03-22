package Medium.no2685;

import java.util.HashSet;

class Solution {

	public int countCompleteComponents(int n, int[][] edges) {

		int[] countEdge = new int[n];
		UnionFind uf = new UnionFind(n);

		for (int[] edge : edges) {
			uf.setUF(edge[0], edge[1]);
			countEdge[edge[0]]++;
			countEdge[edge[1]]++;
		}

		int[] unionCount = new int[n];
		for (int i = 0; i < n; i++) {
			unionCount[uf.getUF(i)]++;
		}

		HashSet<Integer> union = new HashSet<>();
		HashSet<Integer> invalidUnion = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int u = uf.getUF(i);
			union.add(u);
			if (unionCount[u] - 1 != countEdge[i]) {
				invalidUnion.add(u);
			}
		}

		union.removeAll(invalidUnion);

		return union.size();
	}

}

class UnionFind {

	private int[] uf;

	public UnionFind(int length) {
		uf = new int[length];
		for (int i = 0; i < length; i++) {
			uf[i] = i;
		}
	}

	public int getUF(int a) {
		int ufa = uf[a];
		if (ufa != a) {
			uf[a] = getUF(ufa);
		}
		return uf[a];
	}

	public void setUF(int a, int b) {
		int ufa = getUF(a), ufb = getUF(b);
		uf[ufa] = ufb;
	}

}