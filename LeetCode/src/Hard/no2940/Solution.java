package Hard.no2940;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

		int[] result = new int[queries.length];
		Arrays.fill(result, -1);
		List<List<int[]>> deferred = new ArrayList<>();
		for (int i = 0; i < heights.length; i++) {
			deferred.add(new ArrayList<>());
		}
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < queries.length; ++i) {

			int a = Math.min(queries[i][0], queries[i][1]), b = Math.max(queries[i][0], queries[i][1]);
			if (a == b || heights[a] < heights[b])
				result[i] = b;
			else
				deferred.get(b).add(new int[] { heights[a], i });
		}

		for (int i = 0; i < heights.length; ++i) {
			for (int[] query : deferred.get(i))
				que.add(query);
			while (!que.isEmpty() && que.peek()[0] < heights[i]) {
				result[que.poll()[1]] = i;
			}
		}

		return result;
	}
}