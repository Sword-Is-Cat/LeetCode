package Medium.no1319;

import java.util.HashSet;

class Solution {

	int[] uf;

	public int makeConnected(int n, int[][] connections) {

		if (connections.length < n - 1)
			return -1;

		uf = new int[n];
		for (int i = 0; i < n; i++) {
			uf[i] = i;
		}

		for (int[] conn : connections) {
			union(conn[0], conn[1]);
		}

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(getUnion(i));
		}

		return set.size() - 1;
	}

	private void union(int i1, int i2) {
		i1 = getUnion(i1);
		i2 = getUnion(i2);
		if (i1 < i2) {
			uf[i2] = i1;
		} else if (i1 > i2) {
			uf[i1] = i2;
		}
	}

	private int getUnion(int no) {
		if (uf[no] != no)
			uf[no] = getUnion(uf[no]);
		return uf[no];
	}
}