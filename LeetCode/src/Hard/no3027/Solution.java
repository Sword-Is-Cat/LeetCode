package Hard.no3027;

import java.util.Arrays;

class Solution {
	public int numberOfPairs(int[][] points) {

		Arrays.sort(points, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
		int answer = 0;

		for (int i = 0; i < points.length; i++) {

			int ix = points[i][0];
			int minX = Integer.MAX_VALUE;

			for (int j = i + 1; j < points.length; j++) {

				int jx = points[j][0];
				if (jx < ix)
					continue;
				if (jx < minX)
					answer++;
				minX = Math.min(minX, jx);

			}
		}

		return answer;
	}
}