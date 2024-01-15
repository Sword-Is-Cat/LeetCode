package Medium.no2225;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> findWinners(int[][] matches) {

		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>());
		ans.add(new ArrayList<>());

		boolean[] entry = new boolean[100001];
		int[] lose = new int[100001];

		for (int[] match : matches) {
			entry[match[0]] = true;
			entry[match[1]] = true;
			lose[match[1]]++;
		}

		for (int i = 0; i < 100001; i++) {
			if (entry[i] && lose[i] < 2)
				ans.get(lose[i]).add(i);
		}

		return ans;
	}
}