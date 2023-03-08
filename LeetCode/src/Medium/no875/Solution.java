package Medium.no875;

import java.util.Arrays;

class Solution {
	public int minEatingSpeed(int[] piles, int h) {

		int head = 0, tail = Arrays.stream(piles).max().getAsInt();

		while (head + 1 < tail) {
			int mid = (head + tail) / 2;
			long time = 0;

			for (int pile : piles)
				time += 1 + (pile - 1) / mid;

			if (h < time)
				head = mid;
			else
				tail = mid;
		}

		return tail;
	}
}