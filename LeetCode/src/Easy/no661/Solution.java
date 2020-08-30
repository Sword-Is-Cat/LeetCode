package Easy.no661;

class Solution {

	int[][] m;

	public int[][] imageSmoother(int[][] M) {

		m = M;
		int[][] arr = new int[M.length][M[0].length];

		if (m.length == 1 && m[0].length == 1)
			return m;

		if (m.length == 1) {
			for (int i = 0; i < m[0].length; i++) {
				if (i == 0)
					arr[0][i] = (m[0][i] + m[0][i + 1]) / 2;
				else if (i == m[0].length - 1)
					arr[0][i] = (m[0][i - 1] + m[0][i]) / 2;
				else
					arr[0][i] = (m[0][i - 1] + m[0][i] + m[0][i + 1]) / 3;
			}
			return arr;
		}

		if (m[0].length == 1) {
			for (int i = 0; i < m.length; i++) {
				if (i == 0) {
					arr[i][0] = (m[i][0] + m[i + 1][0]) / 2;
				} else if (i == m.length - 1) {
					arr[i][0] = (m[i - 1][0] + m[i][0]) / 2;
				} else {
					arr[i][0] = (m[i - 1][0] + m[i][0] + m[i + 1][0]) / 3;
				}

			}
			return arr;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = smoother(m, i, j);
			}
		}

		return arr;
	}

	int smoother(int[][] m, int i, int j) {

		int count = 0;

		if (i == 0 || i == m.length - 1)
			count++;

		if (j == 0 || j == m[0].length - 1)
			count++;

		int sum = m[i][j];

		if (i == 0 && j == 0) {
			sum += m[i][j + 1];
			sum += m[i + 1][j];
			sum += m[i + 1][j + 1];
		} else if (i == 0 && j == m[0].length - 1) {
			sum += m[i][j - 1];
			sum += m[i + 1][j];
			sum += m[i + 1][j - 1];
		} else if (i == m.length - 1 && j == 0) {
			sum += m[i][j + 1];
			sum += m[i - 1][j];
			sum += m[i - 1][j + 1];
		} else if (i == m.length - 1 && j == m[0].length - 1) {
			sum += m[i][j - 1];
			sum += m[i - 1][j];
			sum += m[i - 1][j - 1];
		} else if (i == 0) {
			sum += m[i][j - 1];
			sum += m[i][j + 1];
			sum += m[i + 1][j];
			sum += m[i + 1][j - 1];
			sum += m[i + 1][j + 1];
		} else if (i == m.length - 1) {
			sum += m[i][j - 1];
			sum += m[i][j + 1];
			sum += m[i - 1][j];
			sum += m[i - 1][j - 1];
			sum += m[i - 1][j + 1];
		} else if (j == 0) {
			sum += m[i - 1][j];
			sum += m[i + 1][j];
			sum += m[i][j + 1];
			sum += m[i - 1][j + 1];
			sum += m[i + 1][j + 1];
		} else if (j == m[0].length - 1) {
			sum += m[i + 1][j];
			sum += m[i - 1][j];
			sum += m[i][j - 1];
			sum += m[i + 1][j - 1];
			sum += m[i - 1][j - 1];
		} else {
			sum += m[i][j - 1];
			sum += m[i][j + 1];
			sum += m[i - 1][j];
			sum += m[i - 1][j - 1];
			sum += m[i - 1][j + 1];
			sum += m[i + 1][j];
			sum += m[i + 1][j - 1];
			sum += m[i + 1][j + 1];
		}

		switch (count) {
		case 0:
			count = 9;
			break;
		case 1:
			count = 6;
			break;
		case 2:
			count = 4;
			break;
		}

		return sum / count;

	}
}