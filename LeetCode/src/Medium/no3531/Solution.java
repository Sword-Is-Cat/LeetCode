package Medium.no3531;

class Solution {
	public int countCoveredBuildings(int n, int[][] buildings) {

		int[][] data = new int[2 * n + 1][2];
		for (int i = 1; i < data.length; i++) {
			data[i][0] = n + 1;
			data[i][1] = 0;
		}

		for (int[] building : buildings) {
			int x = building[0], y = building[1];
			data[x][0] = Math.min(data[x][0], y);
			data[x][1] = Math.max(data[x][1], y);
			data[y + n][0] = Math.min(data[y + n][0], x);
			data[y + n][1] = Math.max(data[y + n][1], x);
		}

		int ans = 0;
		for (int[] building : buildings) {
			int x = building[0], y = building[1];
			if (data[x][0] < y && y < data[x][1] && data[y + n][0] < x && x < data[y + n][1])
				ans++;
		}

		return ans;
	}
}