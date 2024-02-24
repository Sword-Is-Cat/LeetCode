package Hard.no2092;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

		List<List<int[]>> infos = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			infos.add(new ArrayList<>());
		}

		for (int[] meeting : meetings) {
			infos.get(meeting[0]).add(new int[] { meeting[1], meeting[2] });
			infos.get(meeting[1]).add(new int[] { meeting[0], meeting[2] });
		}

		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		queue.add(new int[] { 0, 0 });
		queue.add(new int[] { firstPerson, 0 });

		int[] secret = new int[n];
		Arrays.fill(secret, Integer.MAX_VALUE);

		while (!queue.isEmpty()) {
			int[] info = queue.poll();
			if (secret[info[0]] > info[1]) {
				secret[info[0]] = info[1];
				for (int[] conn : infos.get(info[0])) {
					if (conn[1] >= info[1]) {
						queue.add(conn);
					}
				}
			}
		}

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (secret[i] < Integer.MAX_VALUE)
				answer.add(i);
		}

		return answer;
	}
}