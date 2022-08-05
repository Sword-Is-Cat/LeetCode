package Medium.no378;

import java.util.PriorityQueue;

class Solution {
	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);

		for (int i = 0; i < matrix.length; i++)
			que.add(new int[] { i, 0 });

		int val = 0;

		while (k-- > 0) {
			int[] temp = que.poll();
			val = matrix[temp[0]][temp[1]];
			temp[1]++;
			if (temp[1] < matrix.length)
				que.add(temp);
		}

		return val;
	}
}