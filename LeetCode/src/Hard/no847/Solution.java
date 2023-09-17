package Hard.no847;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int shortestPathLength(int[][] graph) {

		int n = graph.length;
		boolean[][] visit = new boolean[n][1 << n];

		int move = 0, endState = (1 << n) - 1;
		Queue<int[]> que = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int state = stateVisit(0, i);
			que.add(new int[] { i, state });
			visit[i][state] = true;
		}

		while (!que.isEmpty()) {

			int loop = que.size();

			while (loop-- > 0) {

				int[] condition = que.poll();
				int index = condition[0], state = condition[1];

				if (state == endState)
					return move;

				for (int next : graph[index]) {
					int newState = stateVisit(state, next);
					if (!visit[next][newState]) {
						que.add(new int[] { next, newState });
						visit[next][newState] = true;
					}
				}

			}

			move++;

		}

		return -1;
	}

	private int stateVisit(int prevState, int index) {
		return prevState | 1 << index;
	}

}