package Medium.no2924;

class Solution {
	public int findChampion(int n, int[][] edges) {
		boolean[] losed = new boolean[n];
		for (int[] edge : edges) {
			losed[edge[1]] = true;
		}
		int champ = -1;
		boolean hasChamp = false;
		for (int i = 0; i < n; i++) {
			if (!losed[i]) {
				if (hasChamp)
					return -1;
				hasChamp = true;
				champ = i;
			}
		}
		return champ;
	}
}