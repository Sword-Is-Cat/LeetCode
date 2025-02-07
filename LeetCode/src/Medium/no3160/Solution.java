package Medium.no3160;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] queryResults(int limit, int[][] queries) {

		int[] ans = new int[queries.length];
		Map<Integer, Integer> colors = new HashMap<>();
		Map<Integer, Integer> colorCount = new HashMap<>();
		int colorDistinct = 0;

		for (int i = 0; i < queries.length; i++) {
			int idx = queries[i][0], newColor = queries[i][1], oldColor = colors.getOrDefault(idx, 0);
			if (oldColor != 0) {
				if (colorCount.put(oldColor, colorCount.get(oldColor) - 1) == 1)
					colorDistinct--;
			}
			colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);
			if (colorCount.get(newColor) == 1)
				colorDistinct++;
			colors.put(idx, newColor);
			ans[i] = colorDistinct;
		}

		return ans;
	}
}