package Hard.no1579;

import java.util.Arrays;

class Solution {

	public int maxNumEdgesToRemove(int n, int[][] edges) {

		Arrays.sort(edges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		UnionFind auf = new UnionFind(n + 1), buf = new UnionFind(n + 1);

		int cut = 0;

		for (int[] edge : edges) {

			int type = edge[0], s = edge[1], e = edge[2];

			switch (type) {
			case 1:
				if (auf.checkConnect(s, e)) {
					cut++;
				} else {
					auf.setUnion(s, e);
				}
				break;
			case 2:
				if (buf.checkConnect(s, e)) {
					cut++;
				} else {
					buf.setUnion(s, e);
				}
				break;
			case 3:

				if (auf.checkConnect(s, e) && buf.checkConnect(s, e)) {
					cut++;
				} else {
					auf.setUnion(s, e);
					buf.setUnion(s, e);
				}
				break;
			}

		}

		for (int i = 1; i <= n; i++) {
			if (!auf.checkConnect(1, i) || !buf.checkConnect(1, i))
				return -1;
		}

		return cut;

	}
}

class UnionFind {

	int[] uf;

	public UnionFind(int n) {

		uf = new int[n];
		for (int i = 0; i < n; i++) {
			uf[i] = i;
		}
	}

	public int getUnion(int a) {
		int ua = uf[a];
		if (ua != a) {
			uf[a] = getUnion(ua);
		}
		return uf[a];
	}

	public void setUnion(int a, int b) {

		int ua = getUnion(a), ub = getUnion(b);
		uf[Math.max(ua, ub)] = Math.min(ua, ub);
	}

	public boolean checkConnect(int a, int b) {
		return getUnion(a) == getUnion(b);
	}

}