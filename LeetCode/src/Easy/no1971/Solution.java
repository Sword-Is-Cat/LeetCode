package Easy.no1971;

class Solution {

	int[] array;

	public boolean validPath(int n, int[][] edges, int source, int destination) {

		array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = i;

		for (int[] edge : edges) {
			int idx1 = edge[0], idx2 = edge[1];
			int val1 = getValue(idx1), val2 = getValue(idx2);
			if (val1 < val2)
				array[val2] = val1;
			else if (val1 > val2)
				array[val1] = val2;
		}
		return getValue(source) == getValue(destination);
	}

	int getValue(int idx) {
		int val = array[idx];
		if (idx != val) {
			array[idx] = getValue(val);
		}
		return array[idx];
	}
}