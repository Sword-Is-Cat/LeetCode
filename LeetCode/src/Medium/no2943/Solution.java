package Medium.no2943;

import java.util.Arrays;

class Solution {
	public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

		Arrays.sort(hBars);
		Arrays.sort(vBars);
		int prev = 0, conti = 0, hMax = 0, vMax = 0;

		for (int h : hBars) {
			if (prev + 1 == h) {
				conti++;
			} else {
				conti = 2;
			}
			hMax = Math.max(hMax, conti);
			prev = h;
		}

		prev = 0;
		conti = 0;

		for (int v : vBars) {
			if (prev + 1 == v) {
				conti++;
			} else {
				conti = 2;
			}
			vMax = Math.max(vMax, conti);
			prev = v;
		}

		int min = Math.min(hMax, vMax);

		return min * min;
	}
}