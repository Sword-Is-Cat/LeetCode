package Medium.no1962;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int minStoneSum(int[] piles, int k) {

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int pile : piles)
			queue.add(pile);

		while (k-- > 0) {
			queue.add((queue.poll() + 1) / 2);
		}

		return queue.stream().mapToInt(i -> i).sum();
	}
}