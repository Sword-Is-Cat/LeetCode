package Medium.no1942;

import java.util.PriorityQueue;

class Solution {
	public int smallestChair(int[][] times, int targetFriend) {

		int[] seat = new int[times.length];
		PriorityQueue<Integer> arrival = new PriorityQueue<>((a, b) -> Integer.compare(times[a][0], times[b][0]));
		PriorityQueue<Integer> leaving = new PriorityQueue<>((a, b) -> Integer.compare(times[a][1], times[b][1]));
		PriorityQueue<Integer> nextSeat = new PriorityQueue<>();

		for (int i = 0; i < times.length; i++) {
			arrival.add(i);
			leaving.add(i);
			nextSeat.add(i);
		}

		while (!arrival.isEmpty()) {
			if (times[arrival.peek()][0] < times[leaving.peek()][1]) {
				seat[arrival.poll()] = nextSeat.poll();
			} else {
				nextSeat.add(seat[leaving.poll()]);
			}
		}

		return seat[targetFriend];
	}
}