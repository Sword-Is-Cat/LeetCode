package Medium.no3439;

class Solution {
	public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

		int[] freeTimes = new int[startTime.length + 1];
		freeTimes[0] = startTime[0] - 0;
		freeTimes[freeTimes.length - 1] = eventTime - endTime[endTime.length - 1];
		for (int i = 1; i < freeTimes.length - 1; i++) {
			freeTimes[i] = startTime[i] - endTime[i - 1];
		}

		int answer = 0, temp = 0;
		for (int i = 0; i < freeTimes.length; i++) {
			temp += freeTimes[i];
			if (i > k)
				temp -= freeTimes[i - k - 1];
			answer = Math.max(answer, temp);
		}

		return answer;
	}
}