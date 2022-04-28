package Medium.ex1584;

class Solution {

	public int minCostConnectPoints(int[][] points) {

		int cnt = points.length;
		int answer = 0;

		int[] dist = new int[cnt];
		boolean[] visit = new boolean[cnt];

		visit[0] = true;
		int visitCnt = 1;

		for (int i = 0; i < cnt; i++)
			dist[i] = mhtDis(points[0], points[i]);

		while (visitCnt < cnt) {

			int cDis = Integer.MAX_VALUE;
			int idx = -1;

			for (int i = 0; i < cnt; i++) {

				if (!visit[i] && dist[i] < cDis) {

					cDis = dist[i];
					idx = i;
				}
			}

			answer += cDis;
			visit[idx] = true;
			visitCnt++;

			for (int i = 0; i < cnt; i++) {
				if (!visit[i]) {
					dist[i] = Math.min(dist[i], mhtDis(points[idx], points[i]));
				}
			}

		}
		return answer;
	}

	int mhtDis(int[] from, int[] to) {
		return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
	}
}