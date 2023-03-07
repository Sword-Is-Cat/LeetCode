package Medium.no2187;

class Solution {
	public long minimumTime(int[] time, int totalTrips) {

		long head = 0, tail = (long) time[0] * totalTrips;

		while (head + 1 < tail) {

			long mid = (head + tail) / 2, cnt = 0;

			for (int i = 0; i < time.length; i++) {
				cnt += mid / time[i];
			}

			if (cnt < totalTrips)
				head = mid;
			else
				tail = mid;

		}

		return tail;
	}
}