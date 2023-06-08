package Easy.no1351;

class Solution {
	public int countNegatives(int[][] grid) {

		int sum = 0;

		for (int[] array : grid)
			sum += countNegative(array);

		return sum;
	}

	private int countNegative(int[] array) {

		int left = -1, right = array.length;

		while (left + 1 < right) {
			int mid = (left + right) / 2;

			if (array[mid] < 0)
				right = mid;
			else
				left = mid;
		}

		return array.length - right;
	}
}