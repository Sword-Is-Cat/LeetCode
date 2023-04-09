package Medium.no322;

import java.util.ArrayList;

class Solution {

	public int coinChange(int[] coins, int amount) {

		if (amount == 0)
			return 0;

		boolean[] visit = new boolean[amount];
		ArrayList<Integer> prev, curr = new ArrayList<>();

		int count = 0;
		curr.add(0);

		while (!curr.isEmpty()) {
			
			prev = curr;
			curr = new ArrayList<>();

			count++;

			for (int cost : prev) {
				for (int coin : coins) {
					int newCost = cost + coin;
					if (newCost < amount && !visit[newCost]) {
						visit[newCost] = true;
						curr.add(newCost);
					} else if (newCost == amount)
						return count;
				}
			}
		}

		return -1;
	}
}