package Medium.no874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int robotSim(int[] commands, int[][] obstacles) {

		Map<Integer, Set<Integer>> stops = new HashMap<>();
		for (int[] obstacle : obstacles) {
			stops.computeIfAbsent(obstacle[0], v -> new HashSet<>()).add(obstacle[1]);
		}

		int[] coord = { 0, 0 };
		int d = 0, answer = 0;

		for (int cmd : commands) {
			if (cmd == -2) {
				d = (d + 3) % 4;
			} else if (cmd == -1) {
				d = (d + 1) % 4;
			} else {
				coord = move(coord, d, cmd, stops);
				answer = Math.max(answer, coord[0] * coord[0] + coord[1] * coord[1]);
			}
		}

		return answer;
	}

	private int[] move(int[] coord, int direct, int distance, Map<Integer, Set<Integer>> stops) {

		if (distance > 0) {

			int r = coord[0] + dir[direct][0], c = coord[1] + dir[direct][1];
			if (!stops.containsKey(r) || !stops.get(r).contains(c))
				return move(new int[] { r, c }, direct, distance - 1, stops);

		}
		return coord;
	}
}
