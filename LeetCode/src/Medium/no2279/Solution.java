package Medium.no2279;

import java.util.Arrays;

class Solution {
	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

		for (int i = 0; i < capacity.length; i++) {
			capacity[i] -= rocks[i];
		}

		Arrays.sort(capacity);

		int idx = 0;

		while (idx < capacity.length && additionalRocks - capacity[idx] >= 0) {
			additionalRocks -= capacity[idx++];
		}

		return idx;
	}
}