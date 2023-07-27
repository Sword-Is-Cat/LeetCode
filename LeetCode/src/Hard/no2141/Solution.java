package Hard.no2141;

class Solution {
	public long maxRunTime(int n, int[] batteries) {

		long batterySum = 0;
		for (int battery : batteries) {
			batterySum += battery;
		}

		long left = 0, right = batterySum / n + 1;

		while (left + 1 < right) {

			long mid = (left + right) / 2;
			if (canRun(n, mid, batteries)) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return left;

	}

	private boolean canRun(int n, long time, int[] batteries) {

		long sum = 0;

		for (int battery : batteries) {
			sum += Math.min(battery, time);
		}

		return sum >= n * time;
	}
}