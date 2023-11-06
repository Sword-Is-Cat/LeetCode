package Medium.no1845;

import java.util.PriorityQueue;
import java.util.Queue;

class SeatManager {

	Queue<Integer> queue;

	public SeatManager(int n) {
		queue = new PriorityQueue<>();
		for (int i = 1; i <= n; i++)
			queue.add(i);
	}

	public int reserve() {
		return queue.poll();
	}

	public void unreserve(int seatNumber) {
		queue.add(seatNumber);
	}
}