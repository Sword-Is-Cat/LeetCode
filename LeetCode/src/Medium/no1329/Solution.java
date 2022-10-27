package Medium.no1329;

import java.util.PriorityQueue;

class Solution {
	public int[][] diagonalSort(int[][] mat) {

		int row = mat.length, col = 0;

		while (row-- > 0)
			process(mat, row, col);

		row++;

		while (col < mat[row].length)
			process(mat, row, col++);

		return mat;
	}

	public void process(int[][] mat, int row, int col) {

		PriorityQueue<Integer> que = new PriorityQueue<>();

		int r = row, c = col;

		while (r < mat.length && c < mat[r].length)
			que.add(mat[r++][c++]);

		while (row < mat.length && col < mat[row].length)
			mat[row++][col++] = que.poll();

	}

}