package Medium.no733;

class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {

		if (image[sr][sc] != color)
			process(image, sr, sc, image[sr][sc], color);

		return image;
	}

	void process(int[][] image, int row, int col, int asis, int tobe) {

		if (row < 0 || row >= image.length)
			return;
		if (col < 0 || col >= image[row].length)
			return;
		if (image[row][col] != asis)
			return;

		image[row][col] = tobe;

		process(image, row + 1, col, asis, tobe);
		process(image, row - 1, col, asis, tobe);
		process(image, row, col + 1, asis, tobe);
		process(image, row, col - 1, asis, tobe);

	}
}