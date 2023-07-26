package Medium.no1870;

class Solution {
	public int minSpeedOnTime(int[] dist, double hour) {

		int left = 0, right = 10000001;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (isSpeedEnough(dist, (long) Math.round((hour * 100)), mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}

		return left == 10000000 ? -1 : right;
	}

	private boolean isSpeedEnough(int[] dist, long hour, int speed) {

		for (int i = 0; i < dist.length - 1 && hour >= 0; i++) {
			hour -= (int) (Math.ceil(1D * dist[i] / speed)) * 100;
		}
		return hour >= (100D * dist[dist.length - 1] / speed);
	}

}