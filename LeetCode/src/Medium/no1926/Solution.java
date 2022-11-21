package Medium.no1926;

import java.util.HashSet;

class Solution {

	char[][] maze;
	boolean[][] visit;

	public int nearestExit(char[][] maze, int[] entrance) {

		this.maze = maze;
		visit = new boolean[maze.length][maze[0].length];
		visit[entrance[0]][entrance[1]] = true;

		HashSet<int[]> set = new HashSet<>();
		set.add(entrance);

		return bfs(set, 1);
	}

	int bfs(HashSet<int[]> set, int step) {

		if (set == null || set.size() == 0)
			return -1;

		HashSet<int[]> next = new HashSet<>();

		for (int[] coord : set) {

			int row = coord[0], col = coord[1];
			int[] temp;

			temp = new int[] { row + 1, col };
			if (checkVisitable(temp)) {
				next.add(temp);
				if (checkExit(temp))
					return step;
			}

			temp = new int[] { row - 1, col };
			if (checkVisitable(temp)) {
				next.add(temp);
				if (checkExit(temp))
					return step;
			}

			temp = new int[] { row, col + 1 };
			if (checkVisitable(temp)) {
				next.add(temp);
				if (checkExit(temp))
					return step;
			}

			temp = new int[] { row, col - 1 };
			if (checkVisitable(temp)) {
				next.add(temp);
				if (checkExit(temp))
					return step;
			}

		}

		return bfs(next, step + 1);
	}

	boolean checkVisitable(int[] arr) {

		int row = arr[0], col = arr[1];
		if (0 <= row && row < maze.length && 0 <= col && col < maze[row].length) {
			if (maze[row][col] == '.' && !visit[row][col]) {
				visit[row][col] = true;
				return true;
			}
		}
		return false;
	}

	boolean checkExit(int[] arr) {
		int row = arr[0], col = arr[1];
		return row == 0 || row == maze.length - 1 || col == 0 || col == maze[row].length - 1;
	}
}