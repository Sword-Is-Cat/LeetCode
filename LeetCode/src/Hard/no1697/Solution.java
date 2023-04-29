package Hard.no1697;

import java.util.Arrays;

class Solution {

	int[] uf;

	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

		uf = new int[n];
		for (int i = 0; i < n; i++) {
			uf[i] = i;
		}

		for (int i = 0; i < queries.length; i++) {
			queries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
		}

		Arrays.sort(queries, (a, b) -> a[2] - b[2]);
		Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

		boolean[] rst = new boolean[queries.length];

		int ei = 0, qi = 0;

		while (qi < queries.length) {
			int[] query = queries[qi++];

			while (ei < edgeList.length && edgeList[ei][2] < query[2]) {

				int[] edge = edgeList[ei++];
				setUF(edge[0], edge[1]);

			}

			rst[query[3]] = getUF(query[0]) == getUF(query[1]);

		}

		return rst;
	}

	private void setUF(int a, int b) {
		int ua = getUF(a), ub = getUF(b);
		uf[Math.max(ua, ub)] = Math.min(ua, ub);
	}

	private int getUF(int a) {
		int ua = uf[a];
		if (ua != a) {
			uf[a] = getUF(ua);
		}
		return uf[a];
	}
}