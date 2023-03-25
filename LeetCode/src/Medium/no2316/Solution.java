package Medium.no2316;

class Solution {

	int[] uf;

	public long countPairs(int n, int[][] edges) {

		uf = new int[n];
		for (int i = 0; i < n; i++)
			uf[i] = i;

		for (int[] edge : edges)
			setUnion(edge[0], edge[1]);

		long[] cnt = new long[n];

		for (int i = 0; i < n; i++) {
			cnt[getUnion(i)]++;
		}

		long ans = 0;

		for (int i = 0; 0 < n; i++) {
			n -= cnt[i];
			ans += cnt[i] * n;
		}

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