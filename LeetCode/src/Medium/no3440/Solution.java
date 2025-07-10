package Medium.no3440;

class Solution {
	public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

		int length = startTime.length;
		int[] free = new int[length + 1];
		free[0] = startTime[0];
		free[length] = eventTime - endTime[length - 1];
		int[] maxFree = new int[] { Math.max(free[0], free[length]), Math.min(free[0], free[length]), 0 };

		for (int i = 1; i < length; i++) {
			free[i] = startTime[i] - endTime[i - 1];
			if (maxFree[0] < free[i]) {
				maxFree[2] = maxFree[1];
				maxFree[1] = maxFree[0];
				maxFree[0] = free[i];
			} else if (maxFree[1] < free[i]) {
				maxFree[2] = maxFree[1];
				maxFree[1] = free[i];
			} else if (maxFree[2] < free[i]) {
				maxFree[2] = free[i];
			}
		}

		int answer = 0;

		for (int i = 0; i < length; i++) {
			int freeTime = free[i] + free[i + 1], meetingTime = endTime[i] - startTime[i];
			if (getMaxFree(maxFree, free[i], free[i + 1]) >= meetingTime)
				freeTime += meetingTime;
			answer = Math.max(answer, freeTime);
		}

		return answer;
	}

	private int getMaxFree(int[] maxFree, int prevFree, int nextFree) {
		if (maxFree[0] != Math.max(prevFree, nextFree))
			return maxFree[0];
		if (maxFree[1] != Math.min(prevFree, nextFree))
			return maxFree[1];
		return maxFree[2];
	}
}