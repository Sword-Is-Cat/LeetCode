package Easy.no1232;

class Solution {
	public boolean checkStraightLine(int[][] coordinates) {

		boolean isHorizon = coordinates[1][0] - coordinates[0][0] == 0;
		int[] origin = coordinates[0];
		double incl = isHorizon ? 0 : calcIncl(origin, coordinates[1]);

		for (int i = 1; i < coordinates.length; i++) {
			int[] point = coordinates[i];
			if (isHorizon ^ point[0] - origin[0] == 0)
				return false;
			if (isHorizon && point[0] - origin[0] == 0)
				continue;
			if (incl != calcIncl(point, origin))
				return false;
		}

		return true;
	}

	private double calcIncl(int[] co1, int[] co2) {
		double result = 1D;

		result *= co1[1] - co2[1];
		result /= co1[0] - co2[0];

		return result;
	}

}