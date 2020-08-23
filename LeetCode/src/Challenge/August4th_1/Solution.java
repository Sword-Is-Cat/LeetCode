package Challenge.August4th_1;

import java.util.Random;
import java.util.TreeMap;

class Solution {

	int[][] rects;
	Random random;
	int sum;
	TreeMap<Integer, Integer> map;

	public Solution(int[][] rects) {

		this.rects = rects;
		random = new Random();
		sum = 0;
		map = new TreeMap<>();

		for (int i = 0; i < rects.length; i++) {
			sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
			map.put(sum, i);
		}
	}

	public int[] pick() {

		int key = map.ceilingKey(random.nextInt(sum) + 1);
		int[] rect = rects[map.get(key)];
		return new int[] { rect[0] + random.nextInt(rect[2] - rect[0] + 1),
				rect[1] + random.nextInt(rect[3] - rect[1] + 1) };
	}
}