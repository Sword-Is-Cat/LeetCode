package Medium.no223;

import java.util.Arrays;

class Solution {
	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

		int box1area = (ax2 - ax1) * (ay2 - ay1);
		int box2area = (bx2 - bx1) * (by2 - by1);

		int interarea = 0;

		if ((bx2 - ax1) * (bx1 - ax2) < 0 && (by2 - ay1) * (by1 - ay2) < 0) {

			int[] xs = new int[] { ax1, ax2, bx1, bx2 };
			int[] ys = new int[] { ay1, ay2, by1, by2 };

			Arrays.sort(xs);
			Arrays.sort(ys);

			interarea = (xs[2] - xs[1]) * (ys[2] - ys[1]);

		}

		return box1area + box2area - interarea;
	}
}