package Hard.ex52;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int totalNQueens(int n) {
		Checker checker = new Checker();
		return dfs(checker, 0, n);
	}

	int dfs(Checker checker, int row, int n) {

		if (row == n)
			return 1;

		int rst = 0;

		for (int col = 0; col < n; col++) {
			if (checker.isPossible(row, col)) {
				checker.putQueen(row, col);
				rst += dfs(checker, row + 1, n);
				checker.removeQueen(row, col);
			}
		}

		return rst;

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