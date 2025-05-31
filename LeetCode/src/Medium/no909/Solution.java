package Medium.no909;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

	public int snakesAndLadders(int[][] board) {

		int length = board.length, extent = length * length;
		int[] arr = new int[extent + 1];

		int idx = 1;
		for (int row = length - 1; row >= 0; row--) {
			if (row % 2 == length % 2) {
				for (int col = length - 1; col >= 0; col--) {
					arr[idx++] = board[row][col];
				}
			} else {
				for (int col = 0; col < length; col++) {
					arr[idx++] = board[row][col];
				}
			}
		}

		boolean[] visit = new boolean[arr.length];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visit[1] = true;
		int move = 0;

		while (!queue.isEmpty()) {
			move++;
			int loop = queue.size();
			while (loop-- > 0) {
				int curr = queue.poll();
				for (int dice = 1; dice <= 6; dice++) {
					int next = curr + dice;
					if (arr[next] != -1)
						next = arr[next];
					if (!visit[next]) {
						visit[next] = true;
						queue.offer(next);
					}
					if (next == extent)
						return move;
				}
			}
		}

		return -1;
	}

}