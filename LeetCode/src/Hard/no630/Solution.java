package Hard.no630;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int scheduleCourse(int[][] courses) {

		Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

		int time = 0;

		for (int[] course : courses) {

			que.add(course[0]);
			time += course[0];

			if (time > course[1])
				time -= que.poll();
		}
		return que.size();
	}
}