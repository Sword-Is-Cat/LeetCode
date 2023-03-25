package Medium.no2316;

import java.util.HashMap;

class Solution {

	int[] uf;

	public long countPairs(int n, int[][] edges) {

		uf = new int[n];
		for (int i = 0; i < n; i++)
			uf[i] = i;

		for (int[] edge : edges)
			setUnion(edge[0], edge[1]);

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int no = 0; no < n; no++)
			counter.compute(getUnion(no), (k, v) -> v == null ? 1 : (v + 1));

		int[] cnt = new int[counter.keySet().size()];
		int idx = 0;
		for (int key : counter.keySet()) {
			cnt[idx++] = counter.get(key);
		}

		long[] sum = new long[cnt.length];

		for (int i = 0; i < cnt.length; i++) {
			n -= cnt[i];
			sum[i] = n;
		}

		long ans = 0;

		for (int i = 0; i < cnt.length; i++)
			ans += cnt[i] * sum[i];

		return ans;

	}

	private void setUnion(int no1, int no2) {
		no1 = getUnion(no1);
		no2 = getUnion(no2);
		uf[Math.max(no1, no2)] = Math.min(no1, no2);
	}

	private int getUnion(int no) {
		if (uf[no] != no)
			uf[no] = getUnion(uf[no]);
		return uf[no];
	}
}