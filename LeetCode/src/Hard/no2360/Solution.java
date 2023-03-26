package Hard.no2360;

class Solution {

	int length;
	int[] edge, size;

	public int longestCycle(int[] edges) {

		length = edges.length;
		edge = edges;
		size = new int[length];

		int ans = -1;

		for (int i = 0; i < length; i++)
			ans = Math.max(ans, getSize(i));

		return ans;
	}

	private int getSize(int index) {

		if (size[index] == 0)
			size[index] = calcSize(index, edge[index], 1);

		return size[index];
	}

	private int calcSize(int start, int position, int mySize) {

		if (position == -1)
			return -1;

		if (size[position] == 0) {

			int value = -1;

			if (start == position)
				value = mySize;
			else if (mySize > length)
				value = calcSize(position, edge[position], 1);
			else
				value = calcSize(start, edge[position], mySize + 1);

			size[position] = value;
		}

		return size[position];
	}
}
