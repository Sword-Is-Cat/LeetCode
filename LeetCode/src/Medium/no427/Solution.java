package Medium.no427;

class Solution {

	int[][] grid;

	public Node construct(int[][] grid) {
		this.grid = grid;
		return build(0, 0, grid.length);
	}

	protected Node build(int row, int col, int size) {

		boolean isLeaf = true, value = grid[row][col] == 1;
		Node node;

		for (int rd = 0; rd < size; rd++) {
			for (int cd = 0; cd < size; cd++) {
				isLeaf &= !value ^ grid[row + rd][col + rd] == 1;
			}
		}
		node = new Node(value, isLeaf);

		if (!node.isLeaf) {
			size /= 2;
			node.topLeft = build(row, col, size);
			node.topRight = build(row, col + size, size);
			node.bottomLeft = build(row + size, col, size);
			node.bottomRight = build(row + size, col + size, size);
		}

		return node;
	}
}