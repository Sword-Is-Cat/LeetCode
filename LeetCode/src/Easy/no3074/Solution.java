package Easy.no3074;

import java.util.Arrays;

class Solution {
	public int minimumBoxes(int[] apple, int[] capacity) {
		Arrays.sort(capacity);
		int sum = 0, temp = 0;
		for (int i = 0; i < apple.length; i++) {
			sum += apple[i];
		}

		for (int i = 1; i <= capacity.length; i++) {
			temp += capacity[capacity.length - i];
			if (temp >= sum) {
				return i;
			}
		}

		return -1;
	}
}