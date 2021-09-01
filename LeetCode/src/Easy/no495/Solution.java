package Easy.no495;

class Solution {
	public int findPoisonedDuration(int[] timeSeries, int duration) {

		int poisonEnd = -1;
		int sum = 0;

		for (int i = 0; i < timeSeries.length; i++) {

			int startTime = timeSeries[i];

			if (poisonEnd != -1) {

				if (poisonEnd < startTime) {
					sum += duration;
				} else {
					sum += duration - poisonEnd + startTime - 1;
				}
			}
			poisonEnd = startTime + duration - 1;

		}

		return sum + duration;
	}
}