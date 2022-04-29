package Hard.ex51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public List<List<String>> solveNQueens(int n) {

		List<List<String>> list = new ArrayList<>();
		dfs(list, new Checker(), new int[n], 0, n);
		return list;
	}

	void dfs(List<List<String>> list, Checker checker, int[] position, int row, int n) {

		if (row == n) {
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < n; i++)
				temp.add(buildDotQ(position[i], n));
			list.add(temp);
		} else {

			for (int col = 0; col < n; col++) {

				if (checker.isPossible(row, col)) {

					checker.putQueen(row, col);
					position[row] = col;
					dfs(list, checker, position, row + 1, n);
					checker.removeQueen(row, col);
				}
			}
		}
	}

	String buildDotQ(int idx, int n) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++)
			sb.append(i == idx ? 'Q' : '.');

		return sb.toString();

	}

}

class Checker {

	Set<Integer> rowSet, colSet, sumSet, difSet;

	Checker() {
		rowSet = new HashSet<>();
		colSet = new HashSet<>();
		sumSet = new HashSet<>();
		difSet = new HashSet<>();
	}

	boolean isPossible(int row, int col) {

		if (rowSet.contains(row))
			return false;
		if (colSet.contains(col))
			return false;
		if (sumSet.contains(row + col))
			return false;
		if (difSet.contains(row - col))
			return false;
		return true;

	}

	void putQueen(int row, int col) {
		rowSet.add(row);
		colSet.add(col);
		sumSet.add(row + col);
		difSet.add(row - col);
	}

	void removeQueen(int row, int col) {
		rowSet.remove(row);
		colSet.remove(col);
		sumSet.remove(row + col);
		difSet.remove(row - col);
	}

}