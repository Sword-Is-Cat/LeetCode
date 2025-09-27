package Easy.no812;

class Solution {
	public double largestTriangleArea(int[][] points) {
		double answer = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					answer = Math.max(answer, area(points[i], points[j], points[k]));
				}
			}
		}
		return answer;
	}

	public double area(int[]... points) {
		int length = points.length;
		double result = 0;
		for (int i = 0; i < length; i++) {
			int[] p1 = points[i], p2 = points[(i + 1) % length];
			result += p1[0] * p2[1] - p1[1] * p2[0];
		}

		return Math.abs(result / 2);
	}
}