package Hard.no773;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Solution {

	int[][] swap = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

	public int slidingPuzzle(int[][] board) {

		Map<String, Integer> map = new HashMap<>();
		Queue<String> queue = new ArrayDeque<>();
		queue.offer("123450");

		int move = 0;
		while (!queue.isEmpty()) {
			int loop = queue.size();
			while (loop-- > 0) {
				String item = queue.poll();
				if (!map.containsKey(item)) {
					map.put(item, move);
					char[] arr = item.toCharArray();
					// find index of Zero
					int zi = -1;
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] == '0') {
							zi = i;
						}
					}
					// swap and offer to queue
					for (int swapIdx : swap[zi]) {
						arr[zi] = arr[swapIdx];
						arr[swapIdx] = '0';
						queue.offer(new String(arr));
						arr[swapIdx] = arr[zi];
						arr[zi] = '0';
					}
				}
			}
			move++;
		}

		return map.getOrDefault(arrToStr(board), -1);
	}

	private String arrToStr(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : arr)
			for (int val : row)
				sb.append(val);
		return sb.toString();
	}
}