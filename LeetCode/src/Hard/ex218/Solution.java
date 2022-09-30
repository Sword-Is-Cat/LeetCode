package Hard.ex218;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public List<List<Integer>> getSkyline(int[][] buildings) {

		ArrayList<List<Integer>> answer = new ArrayList<>();

		PriorityQueue<int[]> outque = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PriorityQueue<int[]> highque = new PriorityQueue<>((a, b) -> b[2] - a[2]);
		List<Integer> input = new ArrayList<>();
		input.add(-1);
		input.add(-1);
		int idx = 0, position = buildings[0][0];

		while (idx < buildings.length || !outque.isEmpty()) {
			// 모든 작업이 끝날때까지

			while (idx < buildings.length && buildings[idx][0] == position) {

				int[] arr = buildings[idx++];
				outque.add(arr);
				highque.add(arr);

			}

			while (!outque.isEmpty() && outque.peek()[1] == position) {

				int[] arr = outque.poll();
				highque.remove(arr);

			}

			int height = highque.isEmpty() ? 0 : highque.peek()[2];
			int prevH = input.get(1);
			if (prevH != height) {
				input = new ArrayList<>();
				input.add(position);
				input.add(height);
				answer.add(input);
			}

			position = Math.min(idx < buildings.length ? buildings[idx][0] : Integer.MAX_VALUE,
					outque.isEmpty() ? Integer.MAX_VALUE : outque.peek()[1]);

		}

		return answer;
	}
}