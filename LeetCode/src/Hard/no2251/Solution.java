package Hard.no2251;

import java.util.PriorityQueue;

class Solution {
	public int[] fullBloomFlowers(int[][] flowers, int[] people) {

		PriorityQueue<int[]> unbloom = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> bloomed = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PriorityQueue<int[]> visitor = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int[] flower : flowers) {
			unbloom.add(flower);
		}

		for (int i = 0; i < people.length; i++) {
			visitor.add(new int[] { people[i], i });
		}

		while (!visitor.isEmpty()) {

			int[] visiting = visitor.poll();
			int time = visiting[0], idx = visiting[1];

			while (!unbloom.isEmpty() && unbloom.peek()[0] <= time) {
				bloomed.add(unbloom.poll());
			}

			while (!bloomed.isEmpty() && bloomed.peek()[1] < time) {
				bloomed.poll();
			}

			people[idx] = bloomed.size();

		}

		return people;
	}
}
