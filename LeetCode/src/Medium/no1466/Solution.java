package Medium.no1466;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

class Solution {
	public int minReorder(int n, int[][] connections) {

		HashMap<Integer, ArrayList<Integer>> connTo = new HashMap<>(), connFrom = new HashMap<>();

		for (int[] conn : connections) {
			int from = conn[0], to = conn[1];
			connTo.computeIfAbsent(to, v -> new ArrayList<>()).add(from);
			connFrom.computeIfAbsent(from, v -> new ArrayList<>()).add(to);
		}

		int cntRev = 0;

		boolean[] visit = new boolean[n];
		Queue<Integer> process = new ArrayDeque<>();

		visit[0] = true;
		process.add(0);

		while (!process.isEmpty()) {

			int key = process.poll();

			if (connTo.containsKey(key)) {
				for (int city : connTo.get(key)) {
					if (!visit[city]) {
						visit[city] = true;
						process.add(city);
						//System.out.println("correct connect from " + city + " to " + key);
					}
				}
			}

			if (connFrom.containsKey(key)) {
				for (int city : connFrom.get(key)) {
					if (!visit[city]) {
						visit[city] = true;
						process.add(city);
						cntRev++;
						//System.out.println("reverse connect from " + key + " to " + city);
					}
				}
			}
		}

		return cntRev;
	}
}