package Medium.no983;

class Solution {
	public int mincostTickets(int[] days, int[] costs) {

		int[] aCost = new int[days.length + 1];

		for (int i = 0; i < days.length; i++) {

			int costBefore = aCost[i], day = days[i];
			int myCost;

			// 30일권
			myCost = costBefore + costs[2];
			for (int j = i; j < days.length && days[j] < day + 30; j++) {
				aCost[j + 1] = aCost[j + 1] == 0 ? myCost : Math.min(aCost[j + 1], myCost);
			}

			// 7일권
			myCost = costBefore + costs[1];
			for (int j = i; j < days.length && days[j] < day + 7; j++) {
				aCost[j + 1] = Math.min(aCost[j + 1], myCost);
			}

			// 1일권
			aCost[i + 1] = Math.min(aCost[i + 1], costBefore + costs[0]);

		}

		return aCost[days.length];
	}
}