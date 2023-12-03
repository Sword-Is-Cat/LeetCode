package Easy.no1266;

class Solution {
	public int minTimeToVisitAllPoints(int[][] points) {
		int ans = 0;
		for (int i = 1; i < points.length; i++) {
			ans += calculateTime(points[i - 1], points[i]);
		}
		return ans;
	}

	private int calculateTime(int[] start, int[] end) {
		int moveX = Math.abs(end[0] - start[0]);
		int moveY = Math.abs(end[1] - start[1]);
		return Math.max(moveX, moveY);
	}
}