package Medium.no1552;

import java.util.Arrays;

class Solution {
	public int maxDistance(int[] position, int m) {

		Arrays.sort(position);
		int min = 1, max = position[position.length - 1];

		while (min + 1 < max) {
			int mid = (min + max) / 2;
			if (availableBallCount(position, mid) >= m)
				min = mid;
			else
				max = mid;
		}

		return min;
	}

	private int availableBallCount(int[] positions, int distance) {
		int cnt = 1, prev = positions[0];
		for (int position : positions) {
			if (prev + distance <= position) {
				prev = position;
				cnt++;
			}
		}

		return cnt;
	}
}