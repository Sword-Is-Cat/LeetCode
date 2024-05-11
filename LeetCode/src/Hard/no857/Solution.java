package Hard.no857;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

		int[][] infos = new int[quality.length][2];
		for (int i = 0; i < infos.length; i++) {
			infos[i][0] = quality[i];
			infos[i][1] = wage[i];
		}

		Arrays.sort(infos, (a, b) -> b[0] * a[1] - a[0] * b[1]);

		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
		int qualitySum = 0;
		double ans = Double.MAX_VALUE;

		for (int[] info : infos) {

			qualitySum += info[0];
			que.add(info[0]);

			if (que.size() > k) {
				qualitySum -= que.poll();
			}

			if (que.size() == k) {
				ans = Math.min(ans, 1D * qualitySum * info[1] / info[0]);
			}

		}

		return ans;

	}
}