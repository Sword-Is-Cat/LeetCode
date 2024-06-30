package Hard.no1579;

class Solution {

	public int maxNumEdgesToRemove(int n, int[][] edges) {

		UnionFind auf = new UnionFind(n + 1), buf = new UnionFind(n + 1);

		int cut = 0;

		for (int[] edge : edges) {
			int type = edge[0], s = edge[1], e = edge[2];
			if (type == 3) {
				if (auf.checkConnect(s, e) && buf.checkConnect(s, e)) {
					cut++;
				} else {
					auf.setUnion(s, e);
					buf.setUnion(s, e);
				}
			}
		}

		for (int[] edge : edges) {

			int type = edge[0], s = edge[1], e = edge[2];

			if (type == 1) {
				if (auf.checkConnect(s, e)) {
					cut++;
				} else {
					auf.setUnion(s, e);
				}
			} else if (type == 2) {
				if (buf.checkConnect(s, e)) {
					cut++;
				} else {
					buf.setUnion(s, e);
				}
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