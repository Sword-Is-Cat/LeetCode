package Hard.no827;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	int length;
	int[] dir = { 0, 1, 0, -1, 0 };

	public int largestIsland(int[][] grid) {

		length = grid.length;
		int[][] groups = new int[length][length];
		int group = 0;
		Map<Integer, Integer> sizeMap = new HashMap<>();

		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				if (grid[r][c] == 1 && groups[r][c] == 0) {
					setGroup(r, c, ++group, grid, groups, sizeMap);
				}
			}
		}

		int maxArea = 0;
		for (int groupNo : sizeMap.keySet()) {
			maxArea = Math.max(maxArea, sizeMap.get(groupNo));
		}
		Set<Integer> visitSet = new HashSet<>();

		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				if (grid[r][c] == 0) {
					int temp = 1;
					visitSet.clear();
					for (int d = 0; d < 4; d++) {
						int nr = r + dir[d], nc = c + dir[d + 1];
						if (-1 < nr && -1 < nc && nr < length && nc < length && groups[nr][nc] != 0) {
							if (visitSet.add(groups[nr][nc]))
								temp += sizeMap.get(groups[nr][nc]);
						}
					}
					maxArea = Math.max(maxArea, temp);
				}
			}
		}

		return maxArea;
	}

	private void setGroup(int r, int c, int groupNo, int[][] grid, int[][] groups, Map<Integer, Integer> sizeMap) {

		if (-1 < r && -1 < c && r < length && c < length && grid[r][c] == 1 && groups[r][c] == 0) {
			groups[r][c] = groupNo;
			sizeMap.put(groupNo, sizeMap.getOrDefault(groupNo, 0) + 1);
			for (int d = 0; d < 4; d++) {
				setGroup(r + dir[d], c + dir[d + 1], groupNo, grid, groups, sizeMap);
			}
		}

	}

}