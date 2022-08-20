package Hard.no871;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int minRefuelStops(int target, int fuel, int[][] stations) {

		PriorityQueue<Integer> saveFuel = new PriorityQueue<>(Comparator.reverseOrder());
		int idx = 0, charge = 0;

		while (fuel < target) {

			if (idx < stations.length && fuel >= stations[idx][0]) {
				saveFuel.add(stations[idx][1]);
				idx++;
			} else {

				if (saveFuel.isEmpty())
					return -1;

				fuel += saveFuel.poll();
				charge++;
			}

		}

		return charge;
	}
}