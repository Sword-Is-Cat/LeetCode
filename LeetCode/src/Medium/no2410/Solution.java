package Medium.no2410;

import java.util.Arrays;

class Solution {
	public int matchPlayersAndTrainers(int[] players, int[] trainers) {

		Arrays.sort(players);
		Arrays.sort(trainers);

		int match = 0;
		for (int p = players.length - 1, t = trainers.length - 1; p >= 0 && t >= 0; p--) {
			if (players[p] <= trainers[t]) {
				t--;
				match++;
			}
		}

		return match;
	}
}