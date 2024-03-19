package Medium.no621;

class Solution {
	public int leastInterval(char[] tasks, int n) {

		int[] freqs = new int[26];
		for (char task : tasks) {
			freqs[task - 'A']++;
		}

		int maxFreq = 0, tieCnt = 0;

		for (int freq : freqs) {
			if (maxFreq < freq) {
				maxFreq = freq;
				tieCnt = 1;
			} else if (maxFreq == freq) {
				tieCnt++;
			}
		}

		return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + tieCnt);

	}
}