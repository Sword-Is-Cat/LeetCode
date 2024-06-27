package Easy.no1791;

class Solution {
	public int findCenter(int[][] edges) {
		for (int a : edges[0]) {
			for (int b : edges[1]) {
				if (a == b)
					return a;
			}
		}
		return -1;
	}
}