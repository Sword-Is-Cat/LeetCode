package Medium.no649;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public String predictPartyVictory(String senate) {

		Queue<Integer> que = new ArrayDeque<>();
		int[] counter = new int[2], banned = new int[2];

		for (char ch : senate.toCharArray()) {
			int team = ch == 'R' ? 0 : 1;
			que.add(team);
			counter[team]++;
		}

		while (counter[0] * counter[1] > 0) {

			int player = que.poll();

			if (banned[player] > 0) {
				banned[player]--;
				counter[player]--;
			} else {
				banned[1 - player]++;
				que.add(player);
			}

		}

		return counter[0] > 0 ? "Radiant" : counter[1] > 0 ? "Dire" : null;
	}
}