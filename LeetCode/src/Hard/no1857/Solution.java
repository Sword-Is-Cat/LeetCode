package Hard.no1857;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
	public int largestPathValue(String colors, int[][] edges) {

		char[] color = colors.toCharArray();
		int length = color.length;
		for (int i = 0; i < color.length; i++) {
			color[i] -= 'a';
		}

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[][] counts = new int[length][26];
		int[] cntReceive = new int[length];

		for (int i = 0; i < length; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];
			graph.get(a).add(b);
			cntReceive[b]++;
		}

		HashSet<Integer> progSet = new HashSet<>();

		for (int i = 0; i < length; i++) {
			if (cntReceive[i] == 0)
				progSet.add(i);
		}

		int maxCnt = 0, visit = 0;

		while (!progSet.isEmpty()) {

			int index = progSet.iterator().next();
			progSet.remove(index);

			visit++;
			maxCnt = Math.max(maxCnt, ++counts[index][color[index]]);

			for (int next : graph.get(index)) {

				for (int i = 0; i < 26; i++) {
					counts[next][i] = Math.max(counts[next][i], counts[index][i]);
				}

				if (--cntReceive[next] == 0)
					progSet.add(next);
			}
		}

		return length == visit ? maxCnt : -1;
	}
}