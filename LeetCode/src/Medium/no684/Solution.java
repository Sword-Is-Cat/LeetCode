package Medium.no684;

class Solution {

	int[] uf;

	public int[] findRedundantConnection(int[][] edges) {

		uf = new int[edges.length + 1];
		for (int i = 0; i < uf.length; i++) {
			uf[i] = i;
		}

		for (int[] edge : edges) {
			if (getUF(edge[0]) == getUF(edge[1]))
				return edge;
			setUF(edge[0], edge[1]);
		}
		return null;
	}

	protected int getUF(int a) {
		if (a != uf[a]) {
			uf[a] = getUF(uf[a]);
		}
		return uf[a];
	}

	protected void setUF(int a, int b) {
		a = getUF(a);
		b = getUF(b);
		uf[Math.max(a, b)] = Math.min(a, b);
	}
}