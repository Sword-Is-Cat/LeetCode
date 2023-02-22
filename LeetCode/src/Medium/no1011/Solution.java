package Medium.no1011;

class Solution {
	public int shipWithinDays(int[] weights, int days) {

		int head = 0, tail = 0;

		for (int weight : weights) {
			head = Math.max(head, weight);
			tail += weight;
		}

		head--;

		while (head + 1 < tail) {
			int mid = (head + tail) / 2;
			if (countDaysToShip(weights, mid) <= days)
				tail = mid;
			else
				head = mid;
		}

		return tail;
	}

	protected int countDaysToShip(int[] weights, int capacity) {
		int load = 0, cnt = 1;
		for (int weight : weights) {
			if (load + weight > capacity) {
				cnt++;
				load = weight;
			} else {
				load += weight;
			}
		}
		return cnt;
	}
}