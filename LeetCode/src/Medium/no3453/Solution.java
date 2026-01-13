package Medium.no3453;

class Solution {
	public double separateSquares(int[][] squares) {

		double left = 0, right = 0, totArea = 0;

		for (int[] square : squares) {
			int y = square[1], length = square[2];
			right = Math.max(right, y + length);
			totArea += (double) length * length;
		}

		while (right - left > 0.00001) {
			double mid = (right + left) / 2;

			if (checkArea(mid, squares, totArea)) {
				right = mid;
			} else {
				left = mid;
			}

		}

		return right;
	}

	private boolean checkArea(double check_y, int[][] squares, double totArea) {
		double area = 0;
		for (int[] square : squares) {
			int y = square[1], length = square[2];
			if (y < check_y) {
				area += (double) length * Math.min((double) length, check_y - y);
			}
		}
		return area >= totArea / 2;
	}
}