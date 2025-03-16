package Medium.no2594;

class Solution {
	public long repairCars(int[] ranks, int cars) {

		long min = 0, max = 100L * cars * cars;

		while (max - min > 1) {
			long temp = 0;
			long test = (min + max) / 2;
			for (int rank : ranks) {
				temp += getCarRepair(rank, test);
			}
			if (temp >= cars) {
				max = test;
			} else {
				min = test;
			}
		}

		return max;
	}

	private int getCarRepair(int rank, long time) {
		int result = (int) Math.sqrt(time / rank);
		return result;
	}

}