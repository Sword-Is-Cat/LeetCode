package Easy.no3000;

class Solution {
	public int areaOfMaxDiagonal(int[][] dimensions) {
		int maxDiagonal = 0, ansArea = 0;
		for (int[] dimension : dimensions) {
			int length = dimension[0], width = dimension[1];
			int diag = length * length + width * width;
			int area = length * width;
			if (maxDiagonal < diag) {
				maxDiagonal = diag;
				ansArea = area;
			} else if (maxDiagonal == diag) {
				ansArea = Math.max(ansArea, area);
			}
		}
		return ansArea;
	}
}