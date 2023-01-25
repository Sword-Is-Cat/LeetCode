package Medium.no2359;

import java.util.Arrays;

class Solution {
	public int closestMeetingNode(int[] edges, int node1, int node2) {

		int[] dist1 = new int[edges.length];
		int[] dist2 = new int[edges.length];

		Arrays.fill(dist1, -1);
		Arrays.fill(dist2, -1);

		int posi1 = node1, posi2 = node2, dist = 0;

		while (posi1 != -1 && dist1[posi1] == -1) {

			dist1[posi1] = dist++;
			posi1 = edges[posi1];

		}

		dist = 0;

		while (posi2 != -1 && dist2[posi2] == -1) {

			dist2[posi2] = dist++;
			posi2 = edges[posi2];

		}

		int idx = -1, temp = edges.length;

		for (int i = 0; i < edges.length; i++) {

			if (0 <= dist1[i] && 0 <= dist2[i]) {
				int longer = Math.max(dist1[i], dist2[i]);
				if (temp > longer) {
					idx = i;
					temp = longer;
				}
			}
		}

		return idx;
	}
}