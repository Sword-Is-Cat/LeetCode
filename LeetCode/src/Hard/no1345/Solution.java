package Hard.no1345;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int minJumps(int[] arr) {

		HashMap<Integer, Queue<Integer>> map = new HashMap<>();

		for (int idx = 0; idx < arr.length; idx++) {
			map.computeIfAbsent(arr[idx], v -> new LinkedList<>()).add(idx);
		}

		boolean[] visit = new boolean[arr.length];
		Queue<Integer> curr, prev;

		visit[0] = true;
		curr = new LinkedList<>();
		curr.add(0);

		int move = 0, length = arr.length;

		while (!visit[length - 1]) {

			prev = curr;
			curr = new LinkedList<>();
			move++;

			while (!prev.isEmpty()) {
				int idx = prev.poll();

				if (0 < idx && !visit[idx - 1]) {
					curr.add(idx - 1);
					visit[idx - 1] = true;
				}

				if (idx + 1 < length && !visit[idx + 1]) {
					curr.add(idx + 1);
					visit[idx + 1] = true;
				}

				while (!map.get(arr[idx]).isEmpty()) {
					
					int same = map.get(arr[idx]).poll();
					if (!visit[same]) {
						curr.add(same);
						visit[same] = true;
					}
				}

			}

		}

		return move;
	}
}