package Medium.no2352;

import java.util.HashMap;

class Solution {
	public int equalPairs(int[][] grid) {

		HashMap<String, Integer> rowCnt = new HashMap<>(), colCnt = new HashMap<>();

		for (int i = 0; i < grid.length; i++) {

			rowCnt.compute(customToString(grid, i, false), (k, v) -> v == null ? 1 : (v + 1));
			colCnt.compute(customToString(grid, i, true), (k, v) -> v == null ? 1 : (v + 1));

		}

		int ans = 0;

		for (String key : rowCnt.keySet()) {
			if (colCnt.containsKey(key)) {
				ans += rowCnt.get(key) * colCnt.get(key);
			}
		}

		return ans;
	}

	private String customToString(int[][] grid, int index, boolean isVertical) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < grid.length; i++) {
			sb.append('|').append(isVertical ? grid[index][i] : grid[i][index]);
		}

		return sb.toString();

	}

}