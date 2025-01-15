package Medium.no1992;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] findFarmland(int[][] land) {

		List<int[]> list = new ArrayList<>();

		for (int r = 0; r < land.length; r++) {
			for (int c = 0; c < land[r].length; c++) {
				if (land[r][c] == 1)
					list.add(areaSearch(r, c, land, null));
			}
		}

		int[][] ans = new int[list.size()][];
		for (int i = 0; i < ans.length; i++)
			ans[i] = list.get(i);
		return ans;
	}

	int[] dir = { 0, -1, 0, 1, 0 };

	private int[] areaSearch(int r, int c, int[][] land, int[] range) {

		if (r >= 0 && c >= 0 && r < land.length && c < land[r].length && land[r][c] == 1) {

			if (range == null)
				range = new int[] { r, c, r, c };

			range[2] = Math.max(range[2], r);
			range[3] = Math.max(range[3], c);

			land[r][c] = 0;

			for (int d = 0; d < 4; d++) {
				areaSearch(r + dir[d], c + dir[d + 1], land, range);
			}

		}
		return range;
	}

}