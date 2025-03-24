package Medium.no3169;

import java.util.Arrays;

class Solution {
	public int countDays(int days, int[][] meetings) {

		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

		int lastMeeting = 0, emptyDays = 0;

		for (int[] meeting : meetings) {
			emptyDays += Math.max(0, meeting[0] - lastMeeting - 1);
			lastMeeting = Math.max(lastMeeting, meeting[1]);
		}

		emptyDays += Math.max(0, days - lastMeeting);

		return emptyDays;
	}
}