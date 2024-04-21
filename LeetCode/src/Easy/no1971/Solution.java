package Easy.no1971;

class Solution {

	int[] uf;

	public boolean validPath(int n, int[][] edges, int source, int destination) {

		uf = new int[n];
		for (int i = 0; i < n; i++) {
			uf[i] = i;
		}

		for (int[] edge : edges) {
			setUF(edge[0], edge[1]);
		}

		return getUF(source) == getUF(destination);
	}

	private int getUF(int i) {
		if (i != uf[i]) {
			uf[i] = getUF(uf[i]);
		}
		return uf[i];
	}

	private void setUF(int i, int j) {
		i = getUF(i);
		j = getUF(j);
		int min = Math.min(i, j);
		uf[i] = min;
		uf[j] = min;
	}
}