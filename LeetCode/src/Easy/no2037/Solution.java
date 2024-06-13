package Easy.no2037;

class Solution {
	public int minMovesToSeat(int[] seats, int[] students) {

		int[] cntSeat = new int[101], cntStd = new int[101];
		int ans = 0;

		for (int seat : seats) {
			cntSeat[seat]++;
		}
		for (int std : students) {
			cntStd[std]++;
		}

		int i = 0, j = 0;
		while (i < 101 && j < 101) {
			while (i < 101 && cntSeat[i] == 0) {
				i++;
			}
			while (j < 101 && cntStd[j] == 0) {
				j++;
			}

			if (i == 101 || j == 101)
				break;

			ans += Math.abs(i - j);
			cntSeat[i]--;
			cntStd[j]--;
		}

		return ans;
	}
}