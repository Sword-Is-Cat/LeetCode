package Easy.no997;

class Solution {
	public int findJudge(int n, int[][] trust) {

		int[] trusting = new int[n + 1];
		int[] trusted = new int[n + 1];

		for (int[] info : trust) {
			trusting[info[0]]++;
			trusted[info[1]]++;
		}

		for (int i = 1; i < trusted.length; i++) {
			if (trusting[i] == 0 && trusted[i] == n - 1)
				return i;
		}

		return -1;

	}
}