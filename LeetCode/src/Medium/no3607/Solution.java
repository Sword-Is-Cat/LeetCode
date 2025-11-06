package Medium.no3607;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
	public int[] processQueries(int c, int[][] connections, int[][] queries) {

		UnionFind uf = new UnionFind(c + 1);
		for (int[] conn : connections)
			uf.setUnion(conn[0], conn[1]);

		boolean[] isOffline = new boolean[c + 1];

		Map<Integer, Queue<Integer>> map = new HashMap<>();
		for (int i = 1; i <= c; i++) {
			map.computeIfAbsent(uf.getUnion(i), v -> new ArrayDeque<>()).add(i);
		}

		List<Integer> result = new ArrayList<>();
		for (int[] query : queries) {
			if (query[0] == 1) {
				if (isOffline[query[1]]) {
					Queue<Integer> que = map.get(uf.getUnion(query[1]));
					while (!que.isEmpty() && isOffline[que.peek()])
						que.poll();
					result.add(que.isEmpty() ? -1 : que.peek());
				} else {
					result.add(query[1]);
				}
			} else if (query[0] == 2) {
				isOffline[query[1]] = true;
			}
		}

		int[] ans = new int[result.size()];
		for (int i = 0; i < ans.length; i++)
			ans[i] = result.get(i);

		return ans;
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
}